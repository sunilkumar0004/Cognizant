package com.library;

import com.library.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryManagementBootApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/api/books";
    }

    @Test
    public void testCrudOperations() {
        String baseUrl = getBaseUrl();

        // 1. Read initially empty database
        ResponseEntity<Book[]> getResponse = restTemplate.getForEntity(baseUrl, Book[].class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
        int initialCount = getResponse.getBody().length;
        System.out.println("Initial books count: " + initialCount);

        // 2. Create a new Book
        Book book = new Book("Spring in Action", "Craig Walls", "9781617294945");
        ResponseEntity<Book> postResponse = restTemplate.postForEntity(baseUrl, book, Book.class);
        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        Book savedBook = postResponse.getBody();
        assertNotNull(savedBook);
        assertNotNull(savedBook.getId());
        assertEquals("Spring in Action", savedBook.getTitle());
        System.out.println("Created Book: " + savedBook);

        // 3. Read Book by ID
        ResponseEntity<Book> getByIdResponse = restTemplate.getForEntity(baseUrl + "/" + savedBook.getId(), Book.class);
        assertEquals(HttpStatus.OK, getByIdResponse.getStatusCode());
        Book fetchedBook = getByIdResponse.getBody();
        assertNotNull(fetchedBook);
        assertEquals("Spring in Action", fetchedBook.getTitle());
        System.out.println("Fetched Book by ID: " + fetchedBook);

        // 4. Update the Book
        fetchedBook.setTitle("Spring in Action (6th Edition)");
        HttpEntity<Book> requestEntity = new HttpEntity<>(fetchedBook);
        ResponseEntity<Book> putResponse = restTemplate.exchange(baseUrl + "/" + fetchedBook.getId(), HttpMethod.PUT, requestEntity, Book.class);
        assertEquals(HttpStatus.OK, putResponse.getStatusCode());
        Book updatedBook = putResponse.getBody();
        assertNotNull(updatedBook);
        assertEquals("Spring in Action (6th Edition)", updatedBook.getTitle());
        System.out.println("Updated Book: " + updatedBook);

        // 5. Delete the Book
        ResponseEntity<Void> deleteResponse = restTemplate.exchange(baseUrl + "/" + updatedBook.getId(), HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
        System.out.println("Deleted Book with ID: " + updatedBook.getId());

        // 6. Verify deleted Book returns 404
        ResponseEntity<Book> getDeletedResponse = restTemplate.getForEntity(baseUrl + "/" + updatedBook.getId(), Book.class);
        assertEquals(HttpStatus.NOT_FOUND, getDeletedResponse.getStatusCode());
        System.out.println("Verified book is no longer present (received 404).");
    }
}
