package ru.jabki.x6.order.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Component
public class UserClient {
    private final RestClient restClient;

    public UserClient(@Qualifier("restClientUser") RestClient restClient) {
        this.restClient = restClient;
    }

    public boolean existsById(Long userId) {
        try {
            return restClient.get()
                    .uri("/user/exists/{id}", userId)
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