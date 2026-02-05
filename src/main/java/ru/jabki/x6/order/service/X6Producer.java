package ru.jabki.x6.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.jabki.x6.order.configuration.RabbitConfigProperties;
import ru.jabki.x6.order.model.Order;

@Component
@RequiredArgsConstructor
public class X6Producer {
    private final RabbitTemplate rabbitTemplate;
    private final RabbitConfigProperties properties;

    public void send(Order order) {
        rabbitTemplate.convertAndSend(properties.getExchange(), properties.getQueue(), order);
    }
}