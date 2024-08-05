CREATE TABLE users
(
    id          VARCHAR(255) NOT NULL PRIMARY KEY,
    login       VARCHAR(255) NOT NULL,
    password    VARCHAR(255) NOT NULL,
    permissions VARCHAR(255) NOT NULL
);
