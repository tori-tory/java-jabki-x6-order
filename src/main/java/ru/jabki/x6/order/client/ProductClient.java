package ru.jabki.x6.order.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import java.util.List;
import java.util.Map;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(@Qualifier("restClientProduct") RestClient restClient) {
        this.restClient = restClient;
    }

    public boolean checkProductsExist(List<Long> productIds) {
        try {
            return restClient.post()
                    .uri("/product/check-exists")
                    .body(Map.of("ids", productIds))
                    .retrieve()
                    .body(Boolean.class);
        } catch (RestClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return false;
            }
            throw e;
        }
    }
}