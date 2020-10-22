--liquibase formatted sql
--changeset pkslow:1
create table student (
    id int primary key,
    name varchar(255)
);
--rollback drop table student;

--changeset pkslow:2
insert into student (id, name) values (1, 'Larry');
insert into student (id,  name) values (2, 'Simon');
--rollback delete from student;