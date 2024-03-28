package com.example.springboothomwork002.service;

import com.example.springboothomwork002.model.Course;
import com.example.springboothomwork002.model.dto.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourse(Integer offset , Integer limit);

    Course createCourse(CourseRequest courseRequest);

    Course findCourseById(Integer id);

    Course updateCourse(CourseRequest courseRequest,Integer id);

    Course deleteCourse(Integer id);
}
