CREATE TABLE products
(
    code        BIGSERIAL PRIMARY KEY,
    name        VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    price       DECIMAL NOT NULL,
    img_Url      VARCHAR(300),
    blocked     BOOLEAN,
    category    VARCHAR(30)
);
