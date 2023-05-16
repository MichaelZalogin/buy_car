CREATE TABLE IF NOT EXISTS auto_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL UNIQUE,
    login    VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO auto_user (name, login, password)
VALUES ('Ivan', 'Ivanov', 'root');
INSERT INTO auto_user (name, login, password)
VALUES ('Petr', 'Petrov', 'root');
INSERT INTO auto_user (name, login, password)
VALUES ('Sidor', 'Sidorov', 'root');