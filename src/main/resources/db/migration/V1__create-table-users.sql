create table users(
    user_id bigint not null auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    document varchar(14) not null unique,
    email varchar(100) not null unique,
    password varchar(255) not null,
    user_type varchar(50) not null,
    balance decimal(10,2) not null,
    is_active bool not null,
    primary key (user_id)
);