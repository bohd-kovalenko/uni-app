INSERT INTO lecturers
VALUES (1, 'PROFESSOR', 'Ivan', 'Nimbov', 999.0);
INSERT INTO lecturers
VALUES (2, 'ASSISTANT', 'Dmytro', 'Savchenko', 189.5);
INSERT INTO lecturers
VALUES (3, 'ASSISTANT', 'Bohdan', 'Jim', 963.9);
INSERT INTO departments
VALUES (1, 'CS', 1);
INSERT INTO departments
VALUES   (2, 'Chemical', 3);

INSERT INTO departments_lecturers VALUES (1,1);
INSERT INTO departments_lecturers VALUES (1,2);
INSERT INTO departments_lecturers VALUES (1,3);
INSERT INTO departments_lecturers VALUES (2,3);