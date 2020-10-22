--liquibase formatted sql
--changeset larry:3
create table order_history (
    id int primary key,
    price int,
    name varchar(255)
);
--rollback drop table order_history;

--changeset larry:4
insert into order_history (id, price, name) values (1, 100, 'T-shirt');
insert into order_history (id, price,  name) values (2, 511, 'Apple iPhone12');
insert into order_history (id, price,  name) values (3, 111, 'Kindle');
--rollback delete from order_history;