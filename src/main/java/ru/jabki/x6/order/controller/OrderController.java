package ru.jabki.x6.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import ru.jabki.x6.order.model.dto.CreateOrderRequest;
import ru.jabki.x6.order.model.dto.OrderApiMapper;
import ru.jabki.x6.order.model.dto.OrderResponse;
import ru.jabki.x6.order.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderApiMapper mapper;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(
                                orderService.createOrder(mapper.toModel(request))
                        )
                );
    }
}