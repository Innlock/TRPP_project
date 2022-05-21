create table "users"
(
    id bigserial constraint users_pk
            primary key,
    username   text not null,
    password   text not null,
    email      text,
    telephone  numeric(10,0),
    is_admin  boolean DEFAULT FALSE
);


create index users_uniqueid_uindex
    on "users" (id);

create index users_username_uindex
    on "users" (username);

-- CREATE TABLE users (
--         id BIGSERIAL PRIMARY KEY,
--         login TEXT NOT NULL,
--         password TEXT NOT NULL
--         );
--
-- CREATE INDEX user_login_idx ON users (login);
-- CREATE INDEX user_password_idx ON users (password);