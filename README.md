# filtroJava

create database RiwiAcademyDB;
use RiwiAcademyDB;

create table student(
id int primary key auto_increment,
name varchar(50),
lastname varchar(50),
active_student boolean,
email varchar(100) unique,
cc varchar(50)
);
-- curso
create table course(
id int primary key auto_increment,
name varchar(50) unique,
description varchar(50)
);

-- calificaciones
create table calificacion(
id int primary key auto_increment,
nota int,
description varchar(50),
course_id int,
foreign key (course_id) references course(id) on delete cascade,
student_id int,
foreign key (student_id) references student(id) on delete cascade
);

-- inscripciones
create table inscription(
id int primary key auto_increment,
course_id int,
foreign key (course_id) references course(id),
student_id int,
foreign key (student_id) references student(id)
);

