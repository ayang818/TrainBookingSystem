create table train_number
(
    id bigint unsigned auto_increment,
    route_id bigint null comment '列车路线',
    train_id varchar(40) null comment '列车编号',
    start_time datetime null comment '出发时间',
    end_time datetime null comment '到达时间',
    ticket_number int null comment '票总数',
    constraint train_number_pk
        primary key (id)
);