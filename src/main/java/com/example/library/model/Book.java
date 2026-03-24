package com.example.library.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String author;
    private boolean isLoaned;

    // Constructor افتراضي
    public Book() {}

    // Constructor لإنشاء كتاب جديد
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isLoaned = false; // افتراضيًا الكتاب متاح
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isLoaned() { return isLoaned; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setLoaned(boolean loaned) { isLoaned = loaned; }
}