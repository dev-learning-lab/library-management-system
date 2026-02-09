package com.Dev_Learning_Lab.library_system.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.repository.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepo;

    public LibraryService(LibraryRepository libraryRepo) {
        this.libraryRepo = libraryRepo;
    }

    public LibraryModel getBookById(String id) {
        return libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<LibraryModel> getBookByAutor(String autor) {
        return libraryRepo.findByAutor(autor);
    }

    public LibraryModel createBook(LibraryModel book) {
        return libraryRepo.save(book);
    }

    public List<LibraryModel> getAllbooks() {
        return libraryRepo.findAll();
    }

    public List<LibraryModel> getByName(String name) {
        return libraryRepo.findByNameIgnoreCase(name);
    }

    public List<LibraryModel> getByDate(String date) {
        return libraryRepo.findByDate(date);
    }

    public List<LibraryModel> getByCategory(String category) {

        return libraryRepo.findByCategoryIgnoreCase(category);
    }

    public LibraryModel updateBook(String id, LibraryModel updatedBook) {

        LibraryModel book = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setName(updatedBook.getName());
        book.setDescription(updatedBook.getDescription());
        book.setCategory(updatedBook.getCategory());
        book.setAutor(updatedBook.getAutor());
        book.setCopiesAvailable(updatedBook.getCopiesAvailable());
        book.setTotalCopies(updatedBook.getTotalCopies());
        book.setDate(updatedBook.getDate());

        return libraryRepo.save(book);
    }

    public void deleteBook(String id) {
        LibraryModel book = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        libraryRepo.delete(book);

    }

    public LibraryModel rentBook(String id) {

        LibraryModel book = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getCopiesAvailable() > 0) {
            book.setCopiesAvailable(book.getCopiesAvailable() - 1);
        }

        else {
            throw new RuntimeException("The book is not available");
        }

        libraryRepo.save(book);

        return book;
    }

    public LibraryModel returnBook(String id) {

        LibraryModel book = libraryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getCopiesAvailable() < book.getTotalCopies()) {
            book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        } else {
            throw new RuntimeException("The book has all copies in the library  ");
        }

        libraryRepo.save(book);

        return book;
    }

    public List<LibraryModel> getAvailableBooks() {

        return libraryRepo.findByCopiesAvailableGreaterThan(0);
    }

}