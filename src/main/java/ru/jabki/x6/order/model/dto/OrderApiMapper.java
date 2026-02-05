package ru.jabki.x6.order.model.dto;

import org.springframework.stereotype.Component;
import ru.jabki.x6.order.model.Order;
import ru.jabki.x6.order.model.OrderLine;

import java.util.List;

@Component
public class OrderApiMapper {

    public Order toModel(CreateOrderRequest request) {
        return Order.builder()
                .userId(request.userId())
                .orderLines(
                        request.orderLines() == null
                                ? List.of()
                                : request.orderLines().stream()
                                .map(this::toModel)
                                .toList()
                )
                .build();
    }

    private OrderLine toModel(OrderLineRequest request) {
        return OrderLine.builder()
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }

    public OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getCreatedAt(),
                order.getOrderLines() == null
                        ? List.of()
                        : order.getOrderLines().stream()
                        .map(this::toResponse)
                        .toList()
        );
    }

    private OrderLineResponse toResponse(OrderLine line) {
        return new OrderLineResponse(
                line.getProductId(),
                line.getQuantity()
        );
    }
}