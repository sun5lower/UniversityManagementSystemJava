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
use University;
ALTER TABLE student ADD column courseEnrolled varchar(20);

CREATE TABLE Course(
id int not null auto_increment,
    name varchar(100) not null,
    start_at time,
    end_at time,
    number_attending int not null,
    last_updated timestamp default current_timestamp,
    created_at timestamp default current_timestamp,
    primary key(id)
);

ALTER TABLE Course MODIFY COLUMN start_at varchar(20);
ALTER TABLE Course MODIFY COLUMN end_at varchar(20);

USE University;
CREATE TABLE IF NOT EXISTS ExamList(
    id int not null auto_increment,
    courseName varchar(100),
    examDate varchar(100),
    studentName varchar(100),
   result int not null,
   last_updated timestamp default current_timestamp,
    created_at timestamp default current_timestamp,
    primary key(id)
);
