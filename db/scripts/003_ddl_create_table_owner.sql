CREATE TABLE owner
(
    id      BIGSERIAL PRIMARY KEY,
    name    TEXT,
    user_id BIGINT NOT NULL UNIQUE REFERENCES auto_user (id)
);