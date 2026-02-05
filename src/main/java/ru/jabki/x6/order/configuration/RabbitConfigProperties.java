package ru.jabki.x6.order.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("app.rabbitmq")
public class RabbitConfigProperties {

    private String queue;
    private String exchange;
}