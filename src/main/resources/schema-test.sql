drop table if exists stu_exams;

create table stu_exams(id bigint generated by default as identity primary key, first varchar(255), last varchar(255), subject varchar(255), result bigint, grade varchar(255));