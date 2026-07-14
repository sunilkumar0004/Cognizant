package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryManagementBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementBootApplication.class, args);
        System.out.println("======================================================================");
        System.out.println("LIBRARY MANAGEMENT SPRING BOOT APPLICATION STARTED SUCCESSFULLY!");
        System.out.println("======================================================================");
    }
}
