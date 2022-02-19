CREATE TABLE IF NOT EXISTS users
(
    id        INTEGER NOT NULL,
    user_name VARCHAR,
    password  VARCHAR,
    PRIMARY KEY (id)
);

INSERT INTO users (id, user_name, password) VALUES (1, 'admin', 'admin12');