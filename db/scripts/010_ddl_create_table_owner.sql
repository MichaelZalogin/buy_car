CREATE TABLE owner
(
    id      BIGSERIAL PRIMARY KEY,
    name    TEXT                             NOT NULL,
    user_id BIGINT REFERENCES auto_user (id) NOT NULL
);