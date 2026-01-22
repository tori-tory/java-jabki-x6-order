package ru.jabki.x6.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.jabki.x6.order.model.Order;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private static final String INSERT = """
            INSERT INTO x6_order.orders (user_id)
            VALUES (:user_id)
            RETURNING *;
            """;

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final OrderRowMapper orderRowMapper;

    public Order create(final Order order) {
        return jdbcTemplate.queryForObject(INSERT, orderToSql(order), orderRowMapper);
    }

    private MapSqlParameterSource orderToSql(final Order order) {
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_id", order.getUserId());
        return params;
    }
}