package ru.jabki.x6.order.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record OrderResponse(
        Long id,
        Long userId,
        OffsetDateTime createdAt,
        List<OrderLineResponse> orderLines
) {
}