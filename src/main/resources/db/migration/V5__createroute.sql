create table route
(
    id bigint unsigned auto_increment,
    start_station varchar(40) null,
    end_station varchar(40) null,
    route_code varchar(50) null,
    constraint route_pk
        primary key (id)
);

create unique index uk_route_code
    on route (route_code);