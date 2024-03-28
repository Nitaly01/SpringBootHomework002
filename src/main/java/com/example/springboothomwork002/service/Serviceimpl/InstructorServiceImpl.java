package com.example.springboothomwork002.service.Serviceimpl;

import com.example.springboothomwork002.model.Instructor;
import com.example.springboothomwork002.model.dto.request.InstructorRequest;
import com.example.springboothomwork002.repository.InstructorRepository;
import com.example.springboothomwork002.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAllInstructor(Integer offset, Integer limit) {
        offset = (offset -1) * limit;
        return instructorRepository.findAllInstructor(offset,limit);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return instructorRepository.findInstructorById(id);
    }

    @Override
    public Instructor saveInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.saveInstructor(instructorRequest);
    }

    @Override
    public Instructor updateInstructor(InstructorRequest  instructor , Integer id) {
        return instructorRepository.updateInstructor(instructor, id);
    }

    @Override
    public Instructor deleteInstructor(Integer id) {
        return instructorRepository.deleteInstructor(id);
    }

}
