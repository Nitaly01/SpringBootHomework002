package com.example.springboothomwork002.controller;

import com.example.springboothomwork002.model.Course;
import com.example.springboothomwork002.model.dto.request.CourseRequest;
import com.example.springboothomwork002.model.dto.response.APIResponse;
import com.example.springboothomwork002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<APIResponse<List<Course>>> findAllCourse(
            @RequestParam (defaultValue = "1") Integer offset, @RequestParam (defaultValue = "3") Integer limit) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The course has been successfully founded.",
                        courseService.findAllCourse(offset, limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Course>> findCourseById(@PathVariable Integer id) {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new APIResponse<>(
//                        "The course has been successfully founded.",
//                        courseService.findCourseById(id),
//                        HttpStatus.OK,
//                        LocalDateTime.now()
//                )
//        );
        Course course = courseService.findCourseById(id);

        if (course != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The course has been successfully founded.",
                        courseService.findCourseById(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "Error: response status is 404",
                            courseService.findCourseById(id),
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse<Course>> createCourse(@RequestBody CourseRequest courseRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The course has been successfully added.",
                        courseService.createCourse(courseRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Course>> updateCourse(@RequestBody CourseRequest courseRequest, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The course has been successfully updated.",
                        courseService.updateCourse(courseRequest, id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Course>> deleteCourse(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIResponse<>(
                        "The course has been successfully removed.",
                        courseService.deleteCourse(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
}
