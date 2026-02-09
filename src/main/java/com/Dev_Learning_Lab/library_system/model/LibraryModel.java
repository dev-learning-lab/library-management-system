package com.Dev_Learning_Lab.library_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "library")
public class LibraryModel {

    @Id
    private String id;

    private String name;
    private String date;
    private String description;
    private String autor;

    private String category;
    private int copiesAvailable;
    private int totalCopies;

    public LibraryModel() {
    }

    public LibraryModel(String id, String name, String date, String description, String autor,
                        String category, int copiesAvailable, int totalCopies) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
        this.autor = autor;
        this.category = category;
        this.copiesAvailable = copiesAvailable;
        this.totalCopies = totalCopies;
    }

    // ✅ DISPONIBILIDAD AUTOMÁTICA (NO se guarda en Mongo)
    public boolean isAvailable() {
        return copiesAvailable > 0;
    }

    // GETTERS & SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    @Override
    public String toString() {
        return "LibraryModel [id=" + id +
                ", name=" + name +
                ", autor=" + autor +
                ", category=" + category +
                ", date=" + date +
                ", description=" + description +
                ", totalCopies=" + totalCopies +
                ", copiesAvailable=" + copiesAvailable +
                ", available=" + isAvailable() + "]";
    }
}
