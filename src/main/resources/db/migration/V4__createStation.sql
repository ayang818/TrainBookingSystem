create table station
(
    id bigint unsigned auto_increment,
    station_name varchar(40) null,
    constraint station_pk
        primary key (id)
);