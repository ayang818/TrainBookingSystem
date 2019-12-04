drop table user;

create table user
(
    id bigint unsigned auto_increment,
    username varchar(20) null,
    password varchar(20) null,
    email varchar(40) null,
    type tinyint null,
    constraint user_pk
        primary key (id)
);

create unique index uk_username
    on user (username);