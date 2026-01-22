package ru.jabki.x6.order.dto;

import java.math.BigDecimal;

public record OrderLineResponse(
        Long productId,
        BigDecimal quantity
) {
}