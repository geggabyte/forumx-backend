CREATE TABLE IF NOT EXISTS message
(
    id      integer   NOT NULL,
    user_id integer REFERENCES users (id),
    message varchar,
    created timestamp NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO message (id, user_id, message, created)
VALUES (1, 1, 'Hello world!', NOW());