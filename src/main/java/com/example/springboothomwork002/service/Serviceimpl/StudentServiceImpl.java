package com.example.springboothomwork002.service.Serviceimpl;

import com.example.springboothomwork002.model.Student;
import com.example.springboothomwork002.model.dto.request.StudentRequest;
import com.example.springboothomwork002.repository.StudentRepository;
import com.example.springboothomwork002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findALLStudent(Integer offset, Integer limit) {
        offset = (offset -1) * limit;
        return studentRepository.findAllStudent(offset, limit);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentRepository.findAllStudentById(id);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.saveStudent(student);

    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }

}
