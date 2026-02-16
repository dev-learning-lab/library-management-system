import { useState, useEffect } from 'react' // Hooks básicos: useState para datos, useEffect para acciones al cargar
import bookService from './bookService'     // Importamos el objeto con las llamadas a Axios
import './App.css'

function App() {
  // --- ESTADOS (La "memoria" del componente) ---
  const [books, setBooks] = useState([])      // Guarda la lista de libros que viene de Java
  const [loading, setLoading] = useState(true) // Controla si mostramos "Cargando..." o el contenido
  const [error, setError] = useState(null)     // Guarda mensajes de error si la API falla

  // --- EFECTOS (Lo que pasa al iniciar) ---
  useEffect(() => {
    loadBooks() // Ejecuta la carga de libros apenas el usuario abre la página
  }, []) // El array vacío [] significa: "solo hazlo una vez al montar el componente"

  // --- FUNCIONES DE LÓGICA ---

  // 1. Cargar libros (GET)
  const loadBooks = async () => {
    try {
      setLoading(true)                         // Decimos que la carga empezó
      const response = await bookService.getAllBooks() // Esperamos la respuesta de Axios
      setBooks(response.data)                  // Guardamos el JSON (List<LibraryModel>) en el estado
      setError(null)                           // Limpiamos errores previos
    } catch (err) {
      setError('Error al cargar: ' + err.message) 
    } finally {
      setLoading(false)                        // Pase lo que pase, dejamos de mostrar "Cargando..."
    }
  }

  // 2. Rentar libro (POST)
  const handleRent = async (id) => {
    try {
      await bookService.rentBook(id)           // Llamamos al @PostMapping("/{id}/rent") de Java
      alert('¡Libro rentado!')
      loadBooks()                              // RE-CARGAMOS: Importante para ver que "copiesAvailable" bajó
    } catch (err) {
      // Intentamos leer el mensaje que mandó Spring Boot, si no, el de Axios
      alert('Error: ' + (err.response?.data || err.message))
    }
  }

  // 3. Devolver libro (POST)
  const handleReturn = async (id) => {
    try {
      await bookService.returnBook(id)         // Llamamos al @PostMapping("/{id}/return")
      alert('Devuelto con éxito')
      loadBooks()                              // Volvemos a pedir los datos frescos al servidor
    } catch (err) {
      alert('Error: ' + err.message)
    }
  }

  // 4. Eliminar libro (DELETE)
  const handleDelete = async (id) => {
    // window.confirm es una ventana emergente del navegador que devuelve true/false
    if (!window.confirm('¿Eliminar este libro definitivamente?')) return

    try {
      await bookService.deleteBook(id)         // Llamamos al @DeleteMapping("/{id}") de Java
      
      // OPTIMIZACIÓN "UI Optimista": 
      // En lugar de llamar a loadBooks(), filtramos el array localmente para borrarlo rápido de la vista
      setBooks(books.filter(book => book.id !== id)) 
      
      alert('Libro eliminado')
    } catch (err) {
      alert('No se pudo eliminar: ' + err.message)
    }
  }

  // --- RENDERIZADO (Lo que ve el usuario) ---

  // Retornos condicionales: Si hay error o está cargando, mostramos algo distinto
  if (loading) return <div className="status">Cargando biblioteca...</div>
  if (error) return <div className="status error">{error}</div>

  return (
    <div className="App">
      <h1>📚 Mi Biblioteca Digital</h1>
      <p>Libros totales: {books.length}</p>
      
      <div className="book-grid">
        {/* .map() es un bucle que crea un <div> por cada libro en el array */}
        {books.map(book => (
          <div key={book.id} className="book-card"> {/* La key es obligatoria para que React identifique cada item */}
            <h3>{book.name}</h3>
            
            <div className="info">
              <p>Autor: {book.autor}</p>
              <p>Disponibles: {book.copiesAvailable} / {book.totalCopies}</p>
            </div>
            
            <div className="buttons">
              {/* Botón Rentar: se bloquea si no hay copias (atributo disabled) */}
              <button 
                onClick={() => handleRent(book.id)} 
                disabled={book.copiesAvailable === 0}
                className="rent"
              >
                {book.copiesAvailable > 0 ? 'Rentar' : 'Agotado'}
              </button>

              <button onClick={() => handleReturn(book.id)} className="return">
                Devolver
              </button>

              {/* Botón Eliminar: notar que pasamos el ID como argumento */}
              <button onClick={() => handleDelete(book.id)} className="delete">
                Eliminar
              </button>
            </div>
          </div>
        ))}
      </div>

      {/* Renderizado condicional: si la lista está vacía, mostramos este mensaje */}
      {books.length === 0 && <p>No hay libros registrados aún.</p>}
    </div>
  )
}

export default App