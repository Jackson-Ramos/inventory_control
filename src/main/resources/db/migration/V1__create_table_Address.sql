CREATE TABLE tb_Address
(
    adress_id    VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    address_code BIGINT NOT NULL UNIQUE,
    stock        INTEGER,
    deposit      INTEGER,
    read         INTEGER,
    building     INTEGER,
    level        INTEGER,
    apartment    INTEGER
);
