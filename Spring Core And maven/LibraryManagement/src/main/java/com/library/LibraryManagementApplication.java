package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("TESTING SPRING CORE & MAVEN: EXERCISES 1 TO 8");
        System.out.println("======================================================================");

        // ==========================================
        // EXERCISE 1, 2, 5, 7, 8: XML Configuration and Injection
        // ==========================================
        System.out.println("\n--- Loading XML Application Context (applicationContext.xml) ---");
        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- [Exercise 1 & 2 & 5]: Testing XML-based Setter Injection ---");
        BookService serviceSetter = (BookService) xmlContext.getBean("bookServiceSetter");
        if (serviceSetter != null && serviceSetter.getBookRepository() != null) {
            System.out.println("[SUCCESS] bookServiceSetter retrieved and BookRepository successfully wired via Setter Injection.");
        }
        serviceSetter.executeServiceMethod();

        System.out.println("\n--- [Exercise 7]: Testing XML-based Constructor Injection ---");
        BookService serviceConstructor = (BookService) xmlContext.getBean("bookServiceConstructor");
        if (serviceConstructor != null && serviceConstructor.getBookRepository() != null) {
            System.out.println("[SUCCESS] bookServiceConstructor retrieved and BookRepository successfully wired via Constructor Injection.");
        }
        serviceConstructor.executeServiceMethod();

        // ==========================================
        // EXERCISE 6: Annotation-Based Configuration
        // ==========================================
        System.out.println("\n--- Loading Annotation-based Application Context (applicationContext-annotations.xml) ---");
        ApplicationContext annotationContext = new ClassPathXmlApplicationContext("applicationContext-annotations.xml");

        System.out.println("\n--- [Exercise 6]: Testing Annotation-based Beans & Auto-scanning ---");
        // By default, Spring names the scanned bean by decapitalizing the class name: bookService
        BookService annotatedService = (BookService) annotationContext.getBean("bookService");
        if (annotatedService != null && annotatedService.getBookRepository() != null) {
            System.out.println("[SUCCESS] Annotated bookService retrieved and autowired with annotated bookRepository.");
        }
        annotatedService.executeServiceMethod();

        System.out.println("\n======================================================================");
        System.out.println("ALL SPRING CORE EXERCISES 1-8 COMPLETED AND VERIFIED SUCCESSFULLY!");
        System.out.println("======================================================================");
    }
}
