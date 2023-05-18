CREATE TABLE file
(
    id           BIGSERIAL PRIMARY KEY,
    name         TEXT                             NOT NULL,
    path         TEXT                             NOT NULL,
    auto_post_id BIGINT REFERENCES auto_post (id) NOT NULL
);
