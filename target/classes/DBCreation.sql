drop table tblServices cascade;
create table tblServices(id serial NOT NULL primary key, name varchar(50));

drop table tblUsers cascade;
create table tblUsers(id serial NOT NULL primary key, idType varchar(2) NOT NULL, idNumber varchar(20) NOT NULL, firstName varchar(50) NOT NULL, lastName varchar(50) NOT NULL, phone varchar(10), mobile varchar(10), email varchar(100), city varchar(200));

