package com.Dev_Learning_Lab.library_system.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchases")
public class PurchaseModel {

    @Id
    private String id;
    private String bookId;
    private String bookTitle;
    private LocalDateTime purchaseDate;
    private double price;
    private int quantity;

    public PurchaseModel(String id, String bookId, String bookTitle, LocalDateTime purchaseDate, double price, int quantity) {
        this.id = id;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.purchaseDate = purchaseDate != null ? purchaseDate : LocalDateTime.now();
        this.price = price >= 0 ? price : 0;
        this.quantity = quantity > 0 ? quantity : 1;
    }
    
    public PurchaseModel() {
    }

    @Override
    public String toString() {
        return "PurchaseModel [id=" + id +
                ", bookId=" + bookId +
                ", bookTitle=" + bookTitle +
                ", price=" + price +
                ", quantity=" + quantity +
                ", purchaseDate=" + purchaseDate + "]";
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getBookId() {return bookId;}
    public void setBookId(String bookId) {this.bookId = bookId;}
    public String getBookTitle() {return bookTitle;}
    public void setBookTitle(String bookTitle) {this.bookTitle = bookTitle;}
    public LocalDateTime getPurchaseDate() {return purchaseDate;}
    public void setPurchaseDate(LocalDateTime purchaseDate) {this.purchaseDate = purchaseDate;}
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
}
