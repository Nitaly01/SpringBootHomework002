package com.example.springboothomwork002.repository;

import com.example.springboothomwork002.model.Course;
import com.example.springboothomwork002.model.Instructor;
import com.example.springboothomwork002.model.dto.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM courses LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "courseMapper", value ={
            @Result(property = "courseId" , column = "course_id" ),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One (select = "com.example.springboothomwork002.repository.InstructorRepository.findInstructorById"))
    })
    List<Course> findAllCourse(Integer offset , Integer limit);

    @Select("SELECT * FROM courses WHERE course_id = #{id};")
    @ResultMap("courseMapper")
    Course findCourseById(Integer id);
    @Select("INSERT INTO courses (course_name,decription,instructor_id) VALUES (#{course.courseName}, #{course.decription},#{course.instructorId}) RETURNING *")
    @ResultMap("courseMapper")
    Course createCourse(@Param("course") CourseRequest courseRequest);


     @Select("UPDATE courses SET course_name = #{course.courseName}, decription = #{course.decription}, instructor_id = #{course.instructorId} WHERE course_id = #{id} RETURNING *")
    @ResultMap("courseMapper")
    Course updateCourse(@Param("course") CourseRequest courseRequest,Integer id);

     @Select("DELETE FROM courses WHERE course_id = #{id} RETURNING *")
    @ResultMap("courseMapper")
    Course deleteCourse(Integer id);
}
