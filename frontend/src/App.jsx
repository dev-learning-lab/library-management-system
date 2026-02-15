import { useState, useEffect } from 'react'
import bookService from './bookService'
import './App.css'

function App() {
  const [books, setBooks] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  // Cargar libros cuando se monta el componente
  useEffect(() => {
    loadBooks()
  }, [])

  const loadBooks = async () => {
    try {
      setLoading(true)
      const response = await bookService.getAllBooks()
      setBooks(response.data)
      setError(null)
    } catch (err) {
      setError('Error al cargar los libros: ' + err.message)
      console.error(err)
    } finally {
      setLoading(false)
    }
  }

  const handleRent = async (id) => {
    try {
      await bookService.rentBook(id)
      alert('¡Libro rentado!')
      loadBooks() // Recargar lista
    } catch (err) {
      alert('Error: ' + (err.response?.data || err.message))
    }
  }

  if (loading) return <div>Cargando libros...</div>
  if (error) return <div style={{color: 'red'}}>{error}</div>

  return (
    <div className="App">
      <h1>📚 Biblioteca</h1>
      <p>Total de libros: {books.length}</p>
      
      <div style={{display: 'grid', gap: '20px', padding: '20px'}}>
        {books.map(book => (
          <div key={book.id} style={{
            border: '1px solid #ccc',
            padding: '15px',
            borderRadius: '8px'
          }}>
            <h3>{book.name}</h3>
            <p><strong>Autor:</strong> {book.autor}</p>
            <p><strong>Categoría:</strong> {book.category}</p>
            <p><strong>Copias disponibles:</strong> {book.copiesAvailable} / {book.totalCopies}</p>
            
            {book.copiesAvailable > 0 ? (
              <button onClick={() => handleRent(book.id)}>
                Rentar 📖
              </button>
            ) : (
              <button disabled>No disponible ❌</button>
            )}
          </div>
        ))}
      </div>

      {books.length === 0 && (
        <p>No hay libros en la biblioteca. Usa Postman para crear algunos.</p>
      )}
    </div>
  )
}

export default App