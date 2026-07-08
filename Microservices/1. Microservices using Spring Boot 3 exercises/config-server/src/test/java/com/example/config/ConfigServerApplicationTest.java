package com.example.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.profiles.active=native")
public class ConfigServerApplicationTest {

    @Test
    public void contextLoads() {
    }
}
