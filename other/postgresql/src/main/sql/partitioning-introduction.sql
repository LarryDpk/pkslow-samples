drop table pkslow_person_r;
drop table pkslow_person_h;
drop table pkslow_person_l;

CREATE TABLE pkslow_person_r (
                                 age int not null,
                                 city varchar not null
) PARTITION BY RANGE (age);



create table pkslow_person_r1 partition of pkslow_person_r for values from (MINVALUE) to (10);
create table pkslow_person_r2 partition of pkslow_person_r for values from (11) to (20);
create table pkslow_person_r3 partition of pkslow_person_r for values from (21) to (30);
create table pkslow_person_r4 partition of pkslow_person_r for values from (31) to (MAXVALUE);


insert into pkslow_person_r(age, city) VALUES (1, 'GZ');
insert into pkslow_person_r(age, city) VALUES (2, 'SZ');
insert into pkslow_person_r(age, city) VALUES (21, 'SZ');
insert into pkslow_person_r(age, city) VALUES (13, 'BJ');
insert into pkslow_person_r(age, city) VALUES (43, 'SH');
insert into pkslow_person_r(age, city) VALUES (28, 'HK');



select * from pkslow_person_r;


select * from pkslow_person_r3;


----------
create table pkslow_person_l (
                                 age int not null,
                                 city varchar not null
) partition by list (city);

CREATE TABLE pkslow_person_l1 PARTITION OF pkslow_person_l FOR VALUES IN ('GZ');
CREATE TABLE pkslow_person_l2 PARTITION OF pkslow_person_l FOR VALUES IN ('BJ');
CREATE TABLE pkslow_person_l3 PARTITION OF pkslow_person_l DEFAULT;
insert into pkslow_person_l(age, city) VALUES (1, 'GZ');
insert into pkslow_person_l(age, city) VALUES (2, 'SZ');
insert into pkslow_person_l(age, city) VALUES (21, 'SZ');
insert into pkslow_person_l(age, city) VALUES (13, 'BJ');
insert into pkslow_person_l(age, city) VALUES (43, 'SH');
insert into pkslow_person_l(age, city) VALUES (28, 'HK');
insert into pkslow_person_l(age, city) VALUES (28, 'GZ');


select * from pkslow_person_l1;


--------------


create table pkslow_person_h (
                                 age int not null,
                                 city varchar not null
) partition by hash (city);

create table pkslow_person_h1 partition of pkslow_person_h for values with (modulus 4, remainder 0);
create table pkslow_person_h2 partition of pkslow_person_h for values with (modulus 4, remainder 1);
create table pkslow_person_h3 partition of pkslow_person_h for values with (modulus 4, remainder 2);
create table pkslow_person_h4 partition of pkslow_person_h for values with (modulus 4, remainder 3);

insert into pkslow_person_h(age, city) VALUES (1, 'GZ');
insert into pkslow_person_h(age, city) VALUES (2, 'SZ');
insert into pkslow_person_h(age, city) VALUES (21, 'SZ');
insert into pkslow_person_h(age, city) VALUES (13, 'BJ');
insert into pkslow_person_h(age, city) VALUES (43, 'SH');
insert into pkslow_person_h(age, city) VALUES (28, 'HK');

select * from pkslow_person_h4;
