package ru.jabki.x6.order.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestProductConfig {
    @Bean
    public RestClient restClientProduct() {
        return RestClient.builder().baseUrl("http://localhost:8082/api/v1").build();
    }
}