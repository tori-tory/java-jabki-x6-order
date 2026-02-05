CREATE SCHEMA IF NOT EXISTS x6_order;

CREATE TABLE IF NOT EXISTS x6_order.orders (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS x6_order.order_line (
                                 id SERIAL PRIMARY KEY,
                                 order_id BIGINT NOT NULL,
                                 product_id BIGINT NOT NULL ,
                                 quantity DECIMAL(10,2) NOT NULL,
                                 CONSTRAINT fk_order_lines_order
                                     FOREIGN KEY (order_id)
                                         REFERENCES x6_order.orders(id)
                                         ON DELETE CASCADE
);