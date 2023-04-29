CREATE TABLE price_history
(
    id           SERIAL PRIMARY KEY,
    before       BIGINT NOT NULL,
    after        BIGINT NOT NULL,
    created      TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    auto_post_id BIGINT REFERENCES auto_post (id)
);