package com.Dev_Learning_Lab.library_system.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.service.LibraryService;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/books")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<LibraryModel> createBook(@RequestBody LibraryModel book) {
        LibraryModel createdBook = libraryService.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping
    public ResponseEntity<List<LibraryModel>> getAllBooks() {
        List<LibraryModel> books = libraryService.getAllbooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryModel> getBookById(@PathVariable String id) {
        try {
            LibraryModel book = libraryService.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryModel> updateBook(@PathVariable String id, @RequestBody LibraryModel book) {

        try {
            LibraryModel updatedBook = libraryService.updateBook(id, book);
            return ResponseEntity.ok(updatedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        try {
            libraryService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/name")
    public ResponseEntity<List<LibraryModel>> searchByName(@RequestParam String name) {
        List<LibraryModel> books = libraryService.getByName(name);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{autor}")
    public ResponseEntity<List<LibraryModel>> searchByAutor(@PathVariable String autor) {
        try {
            List<LibraryModel> books = libraryService.getBookByAutor(autor);
            return ResponseEntity.ok(books);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<LibraryModel> rentBook(@PathVariable String id) {
        try {
            LibraryModel rentedBook = libraryService.rentBook(id);
            return ResponseEntity.ok(rentedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/available")
    public ResponseEntity<List<LibraryModel>> getAvailableBooks() {

        List<LibraryModel> books = libraryService.getAvailableBooks();

        return ResponseEntity.ok(books);
    }

    @GetMapping("/date")
    public ResponseEntity<List<LibraryModel>> getByDate(@RequestParam String date) {

        List<LibraryModel> books = libraryService.getByDate(date);

        return ResponseEntity.ok(books);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<LibraryModel>> getByCategory(@PathVariable String category) {

        try {
            List<LibraryModel> books = libraryService.getByCategory(category);
            return ResponseEntity.ok(books);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<LibraryModel> returnBook(@PathVariable String id) {
        try {
            LibraryModel returnedBook = libraryService.returnBook(id);
            return ResponseEntity.ok(returnedBook);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<LibraryModel>> getByDateRange(
            @RequestParam String from,
            @RequestParam String to) {
        List<LibraryModel> books = libraryService.getBooksByDateRange(from, to);
        return ResponseEntity.ok(books);
    }

}