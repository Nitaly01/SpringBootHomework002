package com.example.springboothomwork002.model.dto.request;

import com.example.springboothomwork002.model.Course;
import com.example.springboothomwork002.model.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> coursesId;
}
