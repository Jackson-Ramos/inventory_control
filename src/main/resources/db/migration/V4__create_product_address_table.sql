CREATE TABLE products_addresses
(
    product_id BIGINT,
    address_id BIGINT,
    quantity   BIGINT,
    PRIMARY KEY (product_id, address_id),
    CONSTRAINT fk_product_address_product
        FOREIGN KEY (product_id)
            REFERENCES products (code)
            ON DELETE CASCADE,
    CONSTRAINT fk_product_address_address
        FOREIGN KEY (address_id)
            REFERENCES address (code)
            ON DELETE CASCADE
);
