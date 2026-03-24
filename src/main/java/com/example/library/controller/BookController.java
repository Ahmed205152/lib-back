package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // يسمح للـ React بالوصول
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // جلب كل الكتب
    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = service.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // إضافة كتاب جديد
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = service.addBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // استعارة كتاب
    @PutMapping("/loan/{id}")
    public ResponseEntity<Book> loanBook(@PathVariable Integer id) {
        return service.loanBook(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // إرجاع كتاب
    @PutMapping("/return/{id}")
    public ResponseEntity<Book> returnBook(@PathVariable Integer id) {
        return service.returnBook(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}