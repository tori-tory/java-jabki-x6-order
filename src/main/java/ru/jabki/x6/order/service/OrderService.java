package ru.jabki.x6.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jabki.x6.order.client.ProductClient;
import ru.jabki.x6.order.client.UserClient;
import ru.jabki.x6.order.exception.ProductNotFoundException;
import ru.jabki.x6.order.exception.UserNotFoundException;
import ru.jabki.x6.order.model.Order;
import ru.jabki.x6.order.model.OrderLine;
import ru.jabki.x6.order.repository.OrderLineRepository;
import ru.jabki.x6.order.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    @Transactional
    public Order createOrder(Order order) {
        // Лог перед вызовом UserClient
        System.out.println("Calling URL: " + "/user/exists/" + order.getUserId());
        System.out.println("check user with ID: " + order.getUserId());


        System.out.println("Проверка check user… с ID: " + order.getUserId());
        System.out.println("existsById = " + userClient.existsById(order.getUserId()));

        if (!userClient.existsById(order.getUserId())) {
            throw new UserNotFoundException(String.format("Пользователь с id %d не найден",order.getUserId()));
        }

        List<Long> productIds = order.getOrderLines().stream()
                .map(OrderLine::getProductId) // Извлекаем productId из каждого OrderLine
                .collect(Collectors.toList());

        if (!productClient.checkProductsExist(productIds)) {
            throw new ProductNotFoundException("Один или несколько товаров не найдены");
        }

        Order newOrder = orderRepository.create(order);

        if (order.getOrderLines() != null) {
            for (OrderLine line : order.getOrderLines()) {
                orderLineRepository.create(line, newOrder.getId());
            }
        }

        return newOrder;
    }
}