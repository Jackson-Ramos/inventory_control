CREATE TABLE products_addresses
(
    product_id VARCHAR(36) REFERENCES tb_products (product_id),
    adress_id  VARCHAR(36) REFERENCES tb_Address (adress_id),
    PRIMARY KEY (product_id, adress_id)
);
