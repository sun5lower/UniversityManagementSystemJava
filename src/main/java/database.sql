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
