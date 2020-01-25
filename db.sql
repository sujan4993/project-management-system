create table tbl_clients(id int primary key auto_increment,name varchar(255),
email varchar(100),contact_no varchar(100),website varchar(255),address varchar(255),
created_date timestamp default current_timestamp, modified_date timestamp null,
status boolean default true);

create table tbl_projects(id int primary key auto_increment,name varchar(255),
description text,client_id int,deadline date,budget int,
created_date timestamp default current_timestamp, modified_date timestamp null);

alter table tbl_projects add FOREIGN key(client_id) REFERENCES tbl_clients(id);

create table mst_project_status(id int primary key auto_increment,
name varchar(50),
color VARCHAR(50),
created_date timestamp default current_timestamp, modified_date timestamp null);

create table tbl_employees(id int primary key auto_increment,
first_name varchar(50),last_name varchar(50),
email varchar(100),contact_no varchar(100),pan_no varchar(50),
address varchar(255),
created_date timestamp default current_timestamp, modified_date timestamp null,
status boolean default true);

create table tbl_project_status(id int primary key auto_increment,
project_id int,status_id int,
created_date timestamp default current_timestamp,
remarks text);

alter table tbl_project_status add FOREIGN key(project_id) REFERENCES
 tbl_projects(id);

alter table tbl_project_status add FOREIGN key(status_id) REFERENCES
 mst_project_status(id); 

create table tbl_project_employees(id int primary key auto_increment,
project_id int,employee_id int,
created_date timestamp default current_timestamp);


alter table tbl_project_employees add FOREIGN key(project_id) REFERENCES
 tbl_projects(id);

alter table tbl_project_employees add FOREIGN key(employee_id) REFERENCES
 tbl_employees(id);
