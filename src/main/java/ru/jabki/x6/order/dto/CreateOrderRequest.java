package ru.jabki.x6.order.dto;

import java.util.List;

public record CreateOrderRequest(
        Long userId,
        List<OrderLineRequest> orderLines) {
}