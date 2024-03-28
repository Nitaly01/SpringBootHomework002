package com.example.springboothomwork002.controller;

import com.example.springboothomwork002.model.Student;
import com.example.springboothomwork002.model.dto.response.APIResponse;
import com.example.springboothomwork002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Student>>> findAllStudent(
            @RequestParam (defaultValue = "1") Integer offset, @RequestParam (defaultValue = "3") Integer limit){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The student has been successfully founded.",
                        studentService.findALLStudent(offset, limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Student>> findStudentById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The student has been successfully founded.",
                        studentService.findStudentById(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @PutMapping("{id}")
    public ResponseEntity<APIResponse<Student>> updateStudent(@RequestBody Student student, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The student has been successfully updated.",
                        studentService.updateStudent(student),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @PostMapping
    public ResponseEntity<APIResponse<Student>> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The student has been successfully created.",
                        studentService.saveStudent(student),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
}
