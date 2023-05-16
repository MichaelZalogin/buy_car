CREATE TABLE history_owners
(
    id       BIGSERIAL PRIMARY KEY,
    car_id   BIGINT NOT NULL REFERENCES car (id),
    owner_id BIGINT NOT NULL REFERENCES owner (id),
    UNIQUE (car_id, owner_id)
);