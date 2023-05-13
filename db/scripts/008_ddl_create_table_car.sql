CREATE TABLE car
(
    id        BIGSERIAL PRIMARY KEY,
    engine_id BIGINT NOT NULL UNIQUE REFERENCES engine (id)
);