package com.example.springboothomwork002.service;

import com.example.springboothomwork002.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findALLStudent(Integer offset , Integer limit);
   Student findStudentById(Integer id);

    Student updateStudent(Student student);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);

}
