package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Default constructor for setter injection
    public BookService() {
        System.out.println("[BookService] Default constructor called.");
    }

    // Constructor for constructor injection (Exercise 7)
    public BookService(BookRepository bookRepository) {
        System.out.println("[BookService] Parameterized constructor called.");
        this.bookRepository = bookRepository;
    }

    // Setter method for setter injection (Exercise 2, 5, 7)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("[BookService] Setter injection called.");
        this.bookRepository = bookRepository;
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void executeServiceMethod() {
        System.out.println("[BookService] Service method executing...");
        if (bookRepository != null) {
            bookRepository.executeRepositoryMethod();
        } else {
            System.out.println("[BookService] Error: BookRepository is null!");
        }
    }
}
