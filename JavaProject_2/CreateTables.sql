create database SportEvents;
use SportEvents ;
use Java_Project;
delete from user where id = 1;
select *from user
drop table EventsAthletes;
drop table Events;
drop table Athletes;
drop table Reviews;
drop table Users;
drop table Roles;
select *from Role
UPDATE `java_project`.`user` SET `role_id` = '1' WHERE (`id` = '2');
create table Events(
	id int primary key AUTO_INCREMENT,
    name char(50) not null,
    description char(200) not null,
    region char(20),
    date date not null
);

create table Athletes(
	id int primary key AUTO_INCREMENT,
    name char(100) not null
);
insert into Athletes(name) values ('Anton Zverev'), ('Leonardo Messi'),('Moi Povelitel'),('Big Brother');

create table EventsAthletes(
	id int primary key AUTO_INCREMENT,
    idEvents int not null,
    idAthletes int not null,
    foreign key (idEvents) references Events(id),
    foreign key (idAthletes) references Athletes(id)
);

create table Roles
(
	id int primary key AUTO_INCREMENT,
    role char(20)
);
insert into Roles(role) values ('ROLE_ADMIN'), ('ROLE_USER');

create table Users(
	id int primary key AUTO_INCREMENT,
    login char(20) not null,
    password char(200) not null,
    idRole int,
    foreign key (idRole) references Roles(id)
);

Insert  Users (login, password, idRole, email) values('Sidodji','Sidodji',1, 'daniilalisevich@gmail.user_rentuser_rentcom');

ALTER TABLE Users
ADD email VARCHAR(100) NOT NULL;
ALTER TABLE Users
ADD activationCode VARCHAR(200) NULL;

create table Reviews(
	id int primary key AUTO_INCREMENT,
    description char(200) not null,
    photoLink char(100),
    idUser int,
    idEvent int,
    foreign key (idUser) references Users(id),
    foreign key (idEvent) references Events(id)
);

select *from Users;
delete from Users where login = 'Sidodji';
select *from athletes
select *from reviews
select *from events
select *from eventsathletes