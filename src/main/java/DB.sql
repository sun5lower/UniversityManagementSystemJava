CREATE DATABASE IF NOT EXISTs University;

USE University;

CREATE TABLE courses(
id int not null auto_increment,
    name varchar(100) not null,
    start_at time,
    end_at time,
    participant_list varchar(100)  not null,
    last_updated timestamp default current_timestamp,
    created_at timestamp default current_timestamp,
    primary key(id)
);


