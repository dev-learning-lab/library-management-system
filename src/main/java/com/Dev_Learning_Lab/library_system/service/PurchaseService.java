package com.Dev_Learning_Lab.library_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dev_Learning_Lab.library_system.model.LibraryModel;
import com.Dev_Learning_Lab.library_system.model.PurchaseModel;
import com.Dev_Learning_Lab.library_system.repository.LibraryRepository;
import com.Dev_Learning_Lab.library_system.repository.PurchaseRepository;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private LibraryRepository libraryRepository;

    public PurchaseModel buyBook(String bookId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        LibraryModel libro = libraryRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id:" + bookId));

        if (libro.getCopiesAvailable() - quantity < 1) {
            throw new IllegalStateException(
                    String.format("Cannot buy %d copies. Available: %d (must keep at least 1)", quantity,
                            libro.getCopiesAvailable()));
        }

        libro.setCopiesAvailable(libro.getCopiesAvailable() - quantity);
        libraryRepository.save(libro);

        PurchaseModel compra = new PurchaseModel();
        compra.setBookId(bookId);
        compra.setBookTitle(libro.getName());
        compra.setPrice(libro.getPrice());
        compra.setQuantity(quantity);
        compra.setPurchaseDate(LocalDateTime.now());

        return purchaseRepository.save(compra);
    }

    public double calculateTotalGenerated() {
        return purchaseRepository.findAll()
                .stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public double calcularTotalPorLibro(String bookId) {
        return purchaseRepository.findByBookId(bookId)
                .stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public List<PurchaseModel> getAllPurchases() {
        return purchaseRepository.findAll();
    }

}
