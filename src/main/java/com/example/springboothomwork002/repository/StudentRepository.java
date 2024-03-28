package com.example.springboothomwork002.repository;

import com.example.springboothomwork002.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "studentMapper", value ={
            @Result(property = "studentId" , column = "student_id" ),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "course", column = "course_id", one = @One (select = "com.example.springboothomwork002.repository.CourseRepository.findCourseById")),
            @Result(property = "instructor", column = "instructor_id", many = @Many (select = "com.example.springboothomwork002.repository.InstructorRepository.findInstructorById"))
    })
    List<Student> findAllStudent(Integer offset , Integer limit);

    @Select("SELECT * FROM students WHERE student_id = #{id};")
    @ResultMap("studentMapper")
    Student findAllStudentById(Integer id);


    @Select("UPDATE students SET student_name = #{student.studentName}, phone_number = #{student.phoneNumber}, course_id = #{student.courseId} WHERE student_id = #{id} RETURNING *")
    @ResultMap("studentMapper")
    Student updateStudent(Student student);

    @Select("INSERT INTO students (student_id,course_id) VALUES (#{student.studentId},#{student.courseId}) RETURNING *")
    @ResultMap("studentMapper")
    Student addCourse(@Param("student") Student student);

    @Select("INSERT INTO courses (course_name,decription,instructor_id) VALUES (#{course.courseName}, #{course.decription},#{course.instructorId}) RETURNING *")
    @ResultMap("studentMapper")
    Student saveStudent(@Param("course") Student student);

    @Select("DELETE FROM students WHERE student_id = #{id} RETURNING *")
    @ResultMap("studentMapper")
    void deleteStudent(Integer id);
}
