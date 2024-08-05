CREATE TABLE products
(
    code        BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255),
    description TEXT,
    price       DECIMAL,
    imgUrl      VARCHAR(255),
    blocked     BOOLEAN,
    category    VARCHAR(255)
);
