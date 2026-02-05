package ru.jabki.x6.order.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long userId,
        LocalDateTime createdAt,
        List<OrderLineResponse> orderLines) {
}