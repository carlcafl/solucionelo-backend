drop table tblServices cascade;
create table tblServices(id serial NOT NULL primary key, name varchar(50));

drop table tblUsers cascade;
create table tblUsers(id serial NOT NULL primary key, registeredDate timestamp NOT NULL default now(), ipAddress varchar(50) NOT NULL, idType varchar(2) NOT NULL, idNumber varchar(20) NOT NULL, firstName varchar(50) NOT NULL, lastName varchar(50) NOT NULL, phone varchar(10), mobile varchar(10), email varchar(100), referrer varchar(200));

drop table tblServicesByUser cascade;
create table tblServicesByUser(id serial NOT NULL primary key, userId int NOT NULL references tblUsers(id), serviceId int NOT NULL references tblServices(id));

