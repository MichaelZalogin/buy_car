CREATE TABLE IF NOT EXISTS auto_user
(
    id       bigserial PRIMARY KEY,
    login    varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL
);