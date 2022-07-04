create table "book"
(
    id  bigserial
        constraint book_pk
            primary key,
    description text,
    state_book  text,
    year        numeric(4,0),
    cost        numeric(7,2) not null,
    name        text not null,
    author      text not null,
    genre       text not null
);


create index book_uniqueid_uindex
    on "book" (id);