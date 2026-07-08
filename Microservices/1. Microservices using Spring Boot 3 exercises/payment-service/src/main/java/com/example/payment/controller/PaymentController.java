package com.example.payment.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @GetMapping("/charge")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "chargeFallback")
    public ResponseEntity<String> chargePayment() {
        logger.info("Attempting to charge payment...");

        // Simulating call to a slow/down third-party service
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:9999/slow-api", String.class);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<String> chargeFallback(Throwable throwable) {
        logger.warn("Resilience4j Fallback triggered! Reason: {}", throwable.getMessage());
        return ResponseEntity.ok("Payment fallback response: Third-party payment service is currently unavailable. Please try again later.");
    }
}
