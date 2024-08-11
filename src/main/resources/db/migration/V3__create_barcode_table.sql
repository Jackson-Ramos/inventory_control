CREATE TABLE barcodes
(
    id         BIGSERIAL PRIMARY KEY,
    barcode    VARCHAR(255) UNIQUE NOT NULL,
    quantity   BIGINT,
    product_id BIGINT,
    CONSTRAINT fk_product
        FOREIGN KEY (product_id)
            REFERENCES products (code)
            ON DELETE SET NULL
);
