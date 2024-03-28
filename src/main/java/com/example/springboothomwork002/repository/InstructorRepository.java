package com.example.springboothomwork002.repository;

import com.example.springboothomwork002.model.Instructor;
import com.example.springboothomwork002.model.dto.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface InstructorRepository {
    //get All Instructors
    @Select("SELECT * FROM instructors LIMIT #{limit} OFFSET #{offset};")
    @Results(id = "instructorMapper", value ={
            @Result(property = "instructorId" , column = "instructor_id" ),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "email")
    })
    List<Instructor> findAllInstructor(Integer offset , Integer limit);

    // get All Instructors by ID
    @Select("SELECT * FROM instructors WHERE instructor_id = #{id};")
    @ResultMap("instructorMapper")
    Instructor findInstructorById(int id);

    // post Instructors
    @Select("INSERT INTO instructors (instructor_name,email) VALUES (#{instructor.instructorName} , #{instructor.email}) RETURNING *")
    @ResultMap("instructorMapper")
    Instructor saveInstructor(@Param("instructor") InstructorRequest instructorRequest);

    // update Instructors
    @Select("UPDATE instructors SET instructor_name = #{instructor.instructorName}, email = #{instructor.email} WHERE instructor_id = #{id} RETURNING *")
    @ResultMap("instructorMapper")
    Instructor updateInstructor(@Param("instructor") InstructorRequest instructor, Integer id);

    // delete Instructors
    @Select("DELETE FROM instructors WHERE instructor_id = #{instructorId} RETURNING *")
    @ResultMap("instructorMapper")
    Instructor deleteInstructor(Integer id);
}
