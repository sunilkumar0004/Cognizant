package com.example.order.controller;

import com.example.order.model.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestBody Order order) {
        String userServiceUrl = "http://localhost:8081/users/" + order.getUserId();

        return webClientBuilder.build()
                .get()
                .uri(userServiceUrl)
                .retrieve()
                .toBodilessEntity()
                .map(response -> {
                    if (response.getStatusCode().is2xxSuccessful()) {
                        Order savedOrder = orderRepository.save(order);
                        return ResponseEntity.ok(savedOrder);
                    } else {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).<Order>build();
                    }
                })
                .onErrorReturn(ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
