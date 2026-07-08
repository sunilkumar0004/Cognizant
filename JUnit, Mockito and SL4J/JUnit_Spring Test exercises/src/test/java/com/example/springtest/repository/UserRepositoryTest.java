package com.example.springtest.repository;

import com.example.springtest.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName_Found() {
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        userRepository.save(user1);
        userRepository.save(user2);

        List<User> foundUsers = userRepository.findByName("Alice");

        assertEquals(1, foundUsers.size());
        assertEquals("Alice", foundUsers.get(0).getName());
    }

    @Test
    public void testFindByName_NotFound() {
        List<User> foundUsers = userRepository.findByName("Charlie");
        assertTrue(foundUsers.isEmpty());
    }
}
