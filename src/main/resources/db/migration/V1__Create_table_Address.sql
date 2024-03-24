CREATE TABLE tb_Address
(
    adress_id    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    address_code BIGINT NOT NULL UNIQUE,
    amount       BIGINT,
    stock        INTEGER,
    deposit      INTEGER,
    read         INTEGER,
    building     INTEGER,
    level        INTEGER,
    apartment    INTEGER
);
