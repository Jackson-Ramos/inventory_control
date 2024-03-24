CREATE TABLE tb_products
(
    product_id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_code BIGINT         NOT NULL UNIQUE,
    name         VARCHAR(255)   NOT NULL,
    price        NUMERIC(10, 2) NOT NULL
);
