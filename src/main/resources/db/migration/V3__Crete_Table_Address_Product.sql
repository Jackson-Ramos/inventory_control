CREATE TABLE products_addresses
(
    product_id UUID REFERENCES tb_products (product_id),
    adress_id  UUID REFERENCES tb_Address (adress_id),
    PRIMARY KEY (product_id, adress_id)
);
