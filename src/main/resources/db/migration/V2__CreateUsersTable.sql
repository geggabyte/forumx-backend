CREATE TABLE IF NOT EXISTS users
(
    id        INTEGER NOT NULL,
    user_name VARCHAR,
    password  VARCHAR,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS test
(
    id integer NOT NULL,
    name text COLLATE pg_catalog."default",
    "time" integer,
    CONSTRAINT test_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.test
    OWNER to forumx;

insert into test (id, name, time) values (1, 'Insert', 1850);
insert into test (id, name, time) values (2, 'Insert', 1851);
insert into test (id, name, time) values (3, 'Insert', 1852);