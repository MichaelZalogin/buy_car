CREATE TABLE history_owner
(
    id       BIGSERIAL PRIMARY KEY,
    car_id   BIGINT NOT NULL REFERENCES car (id),
    owner_id BIGINT NOT NULL REFERENCES owner (id),
    start_at TIMESTAMP,
    end_at   TIMESTAMP,
    UNIQUE (car_id, owner_id)
);
