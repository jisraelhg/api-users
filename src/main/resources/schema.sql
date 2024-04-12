create table users (
    id varchar(255) not null,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    created_at datetime not null,
    modified_at datetime not null,
    last_login datetime null,
    token varchar(511) not null,
    is_active bit not null,
    primary key (id)
);

create table user_phone (
    id bigint AUTO_INCREMENT not null,
    phone_number varchar(15) not null,
    city_code varchar(7) not null,
    country_code varchar(7) not null,
    user_id varchar(255) not null,
    primary key (id)
);

