CREATE DATABASE demo_mybatis;

CREATE TABLE students(
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(255)
);

CREATE TABLE courses(
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(255),
    description VARCHAR(255),
    instructor_id INT NOT NULL,
    CONSTRAINT courses_instructor_fk FOREIGN KEY(instructor_id) REFERENCES instructors(instructor_id)
                    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE courses_students(
    course_id INT NOT NULL,
    student_id INT NOT NULL,
    PRIMARY KEY (course_id, student_id),
    CONSTRAINT courses_fk FOREIGN KEY(course_id) REFERENCES courses(course_id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT students_fk FOREIGN KEY(student_id) REFERENCES students(student_id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE instructors(
    instructor_id SERIAL PRIMARY KEY,
    instructor_name VARCHAR(255),
    email VARCHAR(255)

);

