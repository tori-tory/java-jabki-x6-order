package ru.jabki.x6.order.model.dto;

import java.util.List;

public record CreateOrderRequest(Long userId, List<OrderLineRequest> orderLines) {
}