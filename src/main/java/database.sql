SET GLOBAL  time_zone = '+3:00';
DROP DATABASE IF EXISTS University;


 CREATE DATABASE IF NOT EXISTS University;
 USE University;

 CREATE TABLE IF NOT EXISTS Student(
     id int not null auto_increment,
     name varchar(100) not null,
     surName varchar(100) not null,
     gradeYear int not null,
     last_updated timestamp default current_timestamp,
     created_at timestamp default current_timestamp,
     primary key(id)
 );

 ALTER TABLE student ADD column courseEnrolled varchar(20);

 CREATE TABLE Course(
 id int not null auto_increment,
     name varchar(100) not null,
     last_updated timestamp default current_timestamp,
     created_at timestamp default current_timestamp,
     primary key(id)
 );



 CREATE TABLE IF NOT EXISTS ExamList(
     id int not null auto_increment,
     courseId varchar(100),
     examDate varchar(100),
     studentId varchar(100),
    result int not null,
    last_updated timestamp default current_timestamp,
     created_at timestamp default current_timestamp,
     primary key(id)
 );

 CREATE TABLE IF NOT EXISTS courseRegistration(
    id int not null auto_increment,
    studentId int not null,
    courseId int not null,
    last_updated timestamp default current_timestamp,
    created_at timestamp default current_timestamp,
    primary key(id)
 );

