package ru.jabki.x6.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class OrderLine {

    @Id
    private Long id;
    private Long productId;
    private BigDecimal quantity;
}