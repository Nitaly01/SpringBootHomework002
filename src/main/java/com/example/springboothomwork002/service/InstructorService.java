package com.example.springboothomwork002.service;

import com.example.springboothomwork002.model.Instructor;
import com.example.springboothomwork002.model.dto.request.InstructorRequest;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructor(Integer offset, Integer limit);

    Instructor findInstructorById(int id);

    Instructor saveInstructor(InstructorRequest instructorRequest);

    Instructor updateInstructor(InstructorRequest instructorRequest, Integer id);

    Instructor deleteInstructor(Integer id);

}
