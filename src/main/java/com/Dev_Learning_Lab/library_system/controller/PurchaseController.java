package com.Dev_Learning_Lab.library_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dev_Learning_Lab.library_system.model.PurchaseModel;
import com.Dev_Learning_Lab.library_system.service.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "*")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseModel>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getTotalGenerated() {
        return ResponseEntity.ok(purchaseService.calculateTotalGenerated());
    }

    @GetMapping("/total/{bookId}")
    public ResponseEntity<Double> getTotalByBook(@PathVariable String bookId) {
        return ResponseEntity.ok(purchaseService.calcularTotalPorLibro(bookId));
    }

    @PostMapping("/buy")
    public ResponseEntity<?> buyBook(@RequestParam String bookId,
            @RequestParam(defaultValue = "1") int quantity) {
        try {
            PurchaseModel purchase = purchaseService.buyBook(bookId, quantity);
            return ResponseEntity.ok(purchase);
        } catch (IllegalStateException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
