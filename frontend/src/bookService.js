import axios from 'axios';

const API_URL = 'http://localhost:8080/api/books';

const bookService = {
    // --- MÉTODOS BÁSICOS (CRUD) ---

    // Mapea a: @GetMapping
    getAllBooks() {
        return axios.get(API_URL);
    },

    // Mapea a: @GetMapping("/{id}")
    getBookById(id) {
        return axios.get(`${API_URL}/${id}`);
    },

    // Mapea a: @PostMapping
    createBook(book) {
        return axios.post(API_URL, book);
    },

    // Mapea a: @PutMapping("/{id}")
    updateBook(id, book) {
        return axios.put(`${API_URL}/${id}`, book);
    },

    // Mapea a: @DeleteMapping("/{id}")
    deleteBook(id) {
        return axios.delete(`${API_URL}/${id}`);
    },

    // --- MÉTODOS DE NEGOCIO (Rentar/Devolver) ---

    // Mapea a: @PostMapping("/{id}/rent")
    rentBook(id) {
        return axios.post(`${API_URL}/${id}/rent`);
    },

    // Mapea a: @PostMapping("/{id}/return")
    returnBook(id) {
        return axios.post(`${API_URL}/${id}/return`);
    },

    // --- MÉTODOS DE BÚSQUEDA Y FILTROS ---

    // Mapea a: @GetMapping("/search/name") -> Usa @RequestParam
    searchByName(name) {
        return axios.get(`${API_URL}/search/name`, { params: { name } });
    },

    // Mapea a: @GetMapping("/author/{autor}") -> Usa @PathVariable
    searchByAuthor(author) {
        return axios.get(`${API_URL}/author/${author}`);
    },

    // Mapea a: @GetMapping("/category/{category}")
    searchByCategory(category) {
        return axios.get(`${API_URL}/category/${category}`);
    },

    // Mapea a: @GetMapping("/available")
    getAvailableBooks() {
        return axios.get(`${API_URL}/available`);
    },

    // Mapea a: @GetMapping("/date") -> Usa @RequestParam
    getByDate(date) {
        return axios.get(`${API_URL}/date`, { params: { date } });
    }
};

export default bookService;