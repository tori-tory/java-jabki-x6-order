package ru.jabki.x6.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("orders")
public class Order {
    @Id
    private Long id;
    private Long userId;
    private OffsetDateTime createdAt;
    @MappedCollection(idColumn = "order_id")
    private List<OrderLine> orderLines;
}