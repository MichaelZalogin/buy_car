CREATE TABLE model
(
    id       BIGSERIAL PRIMARY KEY,
    name     TEXT                         NOT NULL,
    brand_id BIGINT REFERENCES brand (id) NOT NULL
);