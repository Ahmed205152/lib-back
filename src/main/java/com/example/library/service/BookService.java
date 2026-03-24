package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public Optional<Book> loanBook(Integer id) {
        Optional<Book> book = repo.findById(id);
        book.ifPresent(b -> b.setLoaned(true));
        book.ifPresent(repo::save);
        return book;
    }

    public Optional<Book> returnBook(Integer id) {
        Optional<Book> book = repo.findById(id);
        book.ifPresent(b -> b.setLoaned(false));
        book.ifPresent(repo::save);
        return book;
    }
}