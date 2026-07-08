package com.example.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentServiceApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testChargePaymentFallback() {
        ResponseEntity<String> response = restTemplate.getForEntity("/payments/charge", String.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertTrue(response.getBody().contains("fallback"));
    }
}
