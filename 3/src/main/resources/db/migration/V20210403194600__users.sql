create table users
(
    id bigserial constraint users_pk
            primary key,
    email      text not null,
    telephone  numeric(10,0) not null,
    username   text not null,
    is_admin  boolean not null DEFAULT FALSE,
    password   text not null
);


create index users_uniquelid_uindex
    on users (id);

create index users_username_uindex
    on users (username);

-- CREATE TABLE users (
--         id BIGSERIAL PRIMARY KEY,
--         login TEXT NOT NULL,
--         password TEXT NOT NULL
--         );
--
-- CREATE INDEX user_login_idx ON users (login);
-- CREATE INDEX user_password_idx ON users (password);