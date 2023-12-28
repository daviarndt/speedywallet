create table transactions (
    transaction_id bigint not null auto_increment,
    payer_id bigint not null,
    payee_id bigint not null,
    amount decimal(10,2) not null,
    created_at datetime not null,

    primary key (transaction_id),
    constraint fk_payer foreign key (payer_id) references users(user_id),
    constraint fk_payee foreign key (payee_id) references users(user_id)
);