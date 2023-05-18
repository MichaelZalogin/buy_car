CREATE TABLE car
(
    id           BIGSERIAL PRIMARY KEY,
    name         TEXT,
    engine_id    BIGINT NOT NULL REFERENCES engine (id),
    car_brand_id BIGINT NOT NULL REFERENCES car_brand (id)
);