CREATE TABLE address
(
    code      BIGSERIAL PRIMARY KEY,
    stock     INTEGER,
    deposit   INTEGER,
    building  INTEGER,
    road      BIGINT,
    level     INTEGER,
    apartment INTEGER
);
