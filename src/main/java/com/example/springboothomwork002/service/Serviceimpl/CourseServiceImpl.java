package com.example.springboothomwork002.service.Serviceimpl;

import com.example.springboothomwork002.model.Course;
import com.example.springboothomwork002.model.dto.request.CourseRequest;
import com.example.springboothomwork002.repository.CourseRepository;
import com.example.springboothomwork002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAllCourse(Integer offset, Integer limit) {
        offset = (offset -1) * limit;
        return courseRepository.findAllCourse(offset, limit);
    }

    @Override
    public Course createCourse(CourseRequest courseRequest) {
        return courseRepository.createCourse(courseRequest);
    }

    @Override
    public Course findCourseById(Integer id) {
        return courseRepository.findCourseById(id);
    }

    @Override
    public Course updateCourse(CourseRequest courseRequest ,Integer id) {
        return courseRepository.updateCourse(courseRequest ,id);
    }

    @Override
    public Course deleteCourse(Integer id) {
        return courseRepository.deleteCourse(id);
    }
}
