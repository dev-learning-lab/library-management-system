package com.Dev_Learning_Lab.library_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "library")
public class LibraryModel {

    @Id
    private String id;

    private boolean available;
    private String name;
    private String date;
    private String description;

    public LibraryModel() {
    }

    public LibraryModel(String id, boolean available, String name, String date, String description) {
        this.id = id;
        this.available = available;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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

    @Override
    public String toString() {
        return "LibraryModel [id=" + id +
                ", available=" + available +
                ", name=" + name +
                ", date=" + date +
                ", description=" + description + "]";
    }
}
