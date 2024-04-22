CREATE TABLE tb_user
(
    user_id                         SERIAL PRIMARY KEY,
    login                           VARCHAR(255) NOT NULL UNIQUE,
    password                        VARCHAR(255) NOT NULL,
    account_non_expired             BOOLEAN,
    account_non_locked              BOOLEAN,
    account_credentials_non_expired BOOLEAN,
    enabled                         BOOLEAN
);


