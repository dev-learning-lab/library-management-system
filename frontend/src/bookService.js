import axios from 'axios';

const API_URL = 'http://localhost:8080/api/books';

const bookService = {
  
    getAllBooks() {
        return axios.get(API_URL);
    },

   
    createBook(book) {
        return axios.post(API_URL, book);
    },

  
    rentBook(id) {
        return axios.post(`${API_URL}/${id}/rent`);
    },


    returnBook(id) {
        return axios.post(`${API_URL}/${id}/return`);
    },

    deleteBook(id){
        return axios.delete(`${API_URL}/${id}`);
    }

};

export default bookService;