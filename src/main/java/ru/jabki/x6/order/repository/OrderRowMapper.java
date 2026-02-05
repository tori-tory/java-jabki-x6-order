package ru.jabki.x6.order.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.jabki.x6.order.model.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getLong("id"))
                .userId(rs.getLong("user_id"))
                .createdAt(rs.getObject("created_at", LocalDateTime.class))
                .build();
    }
}