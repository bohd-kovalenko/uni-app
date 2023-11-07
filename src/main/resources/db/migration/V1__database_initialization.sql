CREATE TABLE IF NOT EXISTS lecturers
(
    id      int not null
        constraint lecturers_PK primary key,
    degree  varchar(255),
    name    varchar(255),
    surname varchar(255),
    salary  float8
);
CREATE TABLE IF NOT EXISTS departments
(
    id             int                 not null
        constraint departments_PK primary key,
    name           varchar(255) unique not null,
    head_lecturer_id int
        constraint departments_lecturers_FK references lecturers ("id")
);
CREATE TABLE IF NOT EXISTS departments_lecturers
(
    department_id int not null
        constraint departments_lectures_department_FK references departments ("id"),
    lecturer_id   int not null
        constraint departments_lectures_lecturer_FK references lecturers ("id")
);
CREATE SEQUENCE IF NOT EXISTS LECTURERS_SEQUENCE_PK INCREMENT 1 START 1;
CREATE SEQUENCE IF NOT EXISTS DEPARTMENT_SEQUENCE_PK INCREMENT 1 START 1;