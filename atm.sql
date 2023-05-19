create database atm;

use atm;

create table userdetails ( user_id varchar(30), pin_number int(4));
select * from userdetails;
insert into userdetails(user_id,pin_number)values('paul123',1111);
insert into userdetails(user_id,pin_number)values('ani13',2250);
insert into userdetails(user_id,pin_number)values('nil01',2230);

create table accounts(user_id varchar(30), balance int(20));
insert into accounts(user_id,balance)values('paul123',100);
insert into accounts(user_id,balance)values('ani13',20000);
insert into accounts(user_id,balance)values('nil01',25000);
select * from accounts;

create table transactions(tdate varchar(30), user_id varchar(30), transactions varchar(50));
alter table transactions add amount int(20);
select * from transactions;
