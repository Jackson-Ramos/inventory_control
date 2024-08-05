CREATE TABLE address
(
    code      BIGSERIAL PRIMARY KEY,
    stock     BIGINT,
    deposit   BIGINT,
    building  BIGINT,
    road      BIGINT,
    level     BIGINT,
    apartment BIGINT
);
