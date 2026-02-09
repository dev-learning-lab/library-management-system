const modal = document.getElementById('bookModal');
const openModalBtn = document.getElementById('openModalBtn');
const closeBtn = document.querySelector('.close');
const cancelBtn = document.getElementById('cancelBtn');
const bookForm = document.getElementById('bookForm');
const booksTableBody = document.getElementById('booksTableBody');
const notification = document.getElementById('notification');

const API_URL = 'http://localhost:8080/api/books';

openModalBtn.addEventListener('click', () => {
    modal.classList.add('show');
});

closeBtn.addEventListener('click', () => {
    modal.classList.remove('show');
    bookForm.reset();
});

cancelBtn.addEventListener('click', () => {
    modal.classList.remove('show');
    bookForm.reset();
});

window.addEventListener('click', (e) => {
    if (e.target === modal) {
        modal.classList.remove('show');
        bookForm.reset();
    }
});

function showNotification(message, type) {
    notification.textContent = message;
    notification.className = `notification ${type}`;
    notification.classList.add('show');
    
    setTimeout(() => {
        notification.classList.remove('show');
    }, 3000);
}

bookForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    
    const formData = {
        name: document.getElementById('name').value,
        autor: document.getElementById('autor').value,
        category: document.getElementById('category').value,
        date: document.getElementById('date').value,
        description: document.getElementById('description').value,
        totalCopies: parseInt(document.getElementById('totalCopies').value),
        copiesAvailable: parseInt(document.getElementById('copiesAvailable').value)
    };

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        });

        if (response.ok) {
            const newBook = await response.json();
            showNotification('Book added successfully!', 'success');
            bookForm.reset();
            modal.classList.remove('show');
            loadBooks();
        } else {
            showNotification('Error adding book. Please try again.', 'error');
        }
    } catch (error) {
        console.error('Error:', error);
        showNotification('Connection error. Please check your server.', 'error');
    }
});

async function loadBooks() {
    try {
        const response = await fetch(API_URL);
        
        if (response.ok) {
            const books = await response.json();
            displayBooks(books);
        } else {
            booksTableBody.innerHTML = '<tr><td colspan="8" class="loading">Error loading books</td></tr>';
        }
    } catch (error) {
        console.error('Error:', error);
        booksTableBody.innerHTML = '<tr><td colspan="8" class="loading">Connection error</td></tr>';
    }
}

function displayBooks(books) {
    if (books.length === 0) {
        booksTableBody.innerHTML = '<tr><td colspan="8" class="loading">No books found</td></tr>';
        return;
    }

    booksTableBody.innerHTML = books.map(book => `
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.autor}</td>
            <td>${book.category}</td>
            <td>${book.date}</td>
            <td>${book.copiesAvailable}</td>
            <td>${book.totalCopies}</td>
            <td class="actions">
                <button class="btn-edit" onclick="editBook('${book.id}')">Edit</button>
                <button class="btn-delete" onclick="deleteBook('${book.id}')">Delete</button>
            </td>
        </tr>
    `).join('');
}

async function deleteBook(id) {
    if (!confirm('Are you sure you want to delete this book?')) {
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            showNotification('Book deleted successfully!', 'success');
            loadBooks();
        } else {
            showNotification('Error deleting book.', 'error');
        }
    } catch (error) {
        console.error('Error:', error);
        showNotification('Connection error.', 'error');
    }
}

function editBook(id) {
    showNotification('Edit feature coming soon!', 'success');
}

document.addEventListener('DOMContentLoaded', () => {
    loadBooks();
});