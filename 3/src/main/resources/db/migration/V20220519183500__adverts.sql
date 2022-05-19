create table advert
(
    id bigserial not null
        constraint advert_pk
            primary key,
    userid     bigint not null
        constraint advert___fk_user
            references users
            on update cascade on delete cascade,
    bookid     bigint not null
        constraint advert___fk_book_id
            references "book"
            on update cascade on delete cascade,
    state      text not null,
    date       date
);


create unique index advert_uniqueid_uindex
    on advert (id);

create unique index advert_user_uindex
    on advert ("userid");