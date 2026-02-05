package ru.jabki.x6.order.model.dto;

import java.math.BigDecimal;

public record OrderLineResponse(
        Long productId,
        BigDecimal quantity) {
}