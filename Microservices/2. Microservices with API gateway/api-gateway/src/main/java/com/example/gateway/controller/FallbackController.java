package com.example.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/accounts")
    public Mono<ResponseEntity<String>> accountsFallback() {
        return Mono.just(ResponseEntity.ok(
                "Fallback: The Savings Account Service is currently experiencing high load. " +
                "Checking account balance is temporarily offline, but Loan and Insurance services remain fully available."
        ));
    }
}
