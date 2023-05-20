CREATE TABLE IF NOT EXISTS auto_post
(
    id           BIGSERIAL PRIMARY KEY,
    description  TEXT,
    created      TIMESTAMP                        NOT NULL,
    auto_user_id BIGINT REFERENCES auto_user (id) NOT NULL,
    car_id       BIGINT REFERENCES car (id)       NOT NULL
);