SET GLOBAL  time_zone = '+3:00';
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
select * from ExamList;


select * from course
inner join courseRegistration on course.id = courseRegistration.courseId
where courseRegistration.studentId = 1;

select student.name as studentName,  course.name as courseName, ExamList.result, ExamList.examDate
from ExamList
inner join course on course.id = ExamList.courseId
inner join student on student.id = ExamList.studentId
where ExamList.studentId = 1;
select student.name as studentName,  course.name as courseName, ExamList.result, ExamList.examDate
from ExamList
inner join course on course.id = ExamList.courseId
inner join student on student.id = ExamList.studentId
where  course.name LIKE '% + courseName + %'