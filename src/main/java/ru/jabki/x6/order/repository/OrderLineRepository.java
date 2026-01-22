package ru.jabki.x6.order.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.jabki.x6.order.model.OrderLine;

@Repository
@RequiredArgsConstructor
public class OrderLineRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String INSERT = """
        INSERT INTO x6_order.order_line (order_id, product_id, quantity)
        VALUES (:order_id, :product_id, :quantity)
    """;

    public void create(final OrderLine line, final Long orderId) {
        jdbcTemplate.update(INSERT,  orderLineToSql(line, orderId));
    }

    private MapSqlParameterSource orderLineToSql(final OrderLine line, final Long orderId){
        final MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("order_id", orderId);
        params.addValue("product_id", line.getProductId());
        params.addValue("quantity", line.getQuantity());
        return params;
    }
}