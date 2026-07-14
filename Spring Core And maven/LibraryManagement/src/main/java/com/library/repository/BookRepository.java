package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void executeRepositoryMethod() {
        System.out.println("[BookRepository] Database method executed successfully.");
    }
}
