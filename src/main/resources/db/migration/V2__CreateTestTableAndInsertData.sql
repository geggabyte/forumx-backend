CREATE TABLE IF NOT EXISTS test
(
    id integer NOT NULL,
    name varchar,
    "time" integer,
    PRIMARY KEY (id)
);

insert into test (id, name, time) values (1, 'Insert', 1850);
insert into test (id, name, time) values (2, 'Insert', 1851);
insert into test (id, name, time) values (3, 'Insert', 1852);