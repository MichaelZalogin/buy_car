CREATE TABLE car
(
    id              BIGSERIAL PRIMARY KEY,
    name            TEXT                                NOT NULL,
    vin_number      TEXT                                NOT NULL,
    mileage         INT                                 NOT NULL,
    engine_id       BIGINT REFERENCES engine (id)       NOT NULL,
    brand_id        BIGINT REFERENCES brand (id)        NOT NULL,
    model_id        BIGINT REFERENCES model (id)        NOT NULL,
    year_id         BIGINT REFERENCES years (id)        NOT NULL,
    body_id         BIGINT REFERENCES body (id)         NOT NULL,
    color_id        BIGINT REFERENCES color (id)        NOT NULL,
    transmission_id BIGINT REFERENCES transmission (id) NOT NULL,
    fuel_type_id    BIGINT REFERENCES fuel_type (id)    NOT NULL,
    door_count_id   BIGINT REFERENCES door_count (id)   NOT NULL
);