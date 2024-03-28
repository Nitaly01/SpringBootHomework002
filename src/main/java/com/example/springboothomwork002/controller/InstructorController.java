package com.example.springboothomwork002.controller;

import com.example.springboothomwork002.model.Instructor;
import com.example.springboothomwork002.model.dto.request.InstructorRequest;
import com.example.springboothomwork002.model.dto.response.APIResponse;
import com.example.springboothomwork002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<Instructor>>> findAllInstructor(
            @RequestParam (defaultValue = "1") Integer offset, @RequestParam (defaultValue = "3") Integer limit){
        return ResponseEntity.status(HttpStatus.OK).body(
                 new APIResponse<>(
                         "The instructor has been successfully founded.",
                         instructorService.findAllInstructor(offset,limit),
                         HttpStatus.OK,
                         LocalDateTime.now()
                 )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Instructor>> findInstructorById(@PathVariable int id) {
        if (instructorService == null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new APIResponse<>(
                            "The instructor has been successfully founded.",
                            instructorService.findInstructorById(id),
                            HttpStatus.OK,
                            LocalDateTime.now()
                    )
            );
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new APIResponse<>(
                            "The instructor has been successfully founded.",
                            instructorService.findInstructorById(id),
                            HttpStatus.NOT_FOUND,
                            LocalDateTime.now()
                    )
            );
        }
    }

    @PostMapping
    public ResponseEntity<APIResponse<Instructor>> saveInstructor(@RequestBody InstructorRequest instructorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new APIResponse<>(
                        "The instructor has been successfully created.",
                        instructorService.saveInstructor(instructorRequest),
                        HttpStatus.CREATED,
                        LocalDateTime.now()
                )
        );

    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<Instructor>> updateInstructor(@RequestBody InstructorRequest instructor, @PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(
               new APIResponse<>(
                       "The instructor has been successfully updated.",
                       instructorService.updateInstructor(instructor,id),
                       HttpStatus.OK,
                       LocalDateTime.now()
               )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<Instructor>> deleteInstructor(@PathVariable Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(
               new APIResponse<>(
                       "The instructor has been successfully removed.",
                       instructorService.deleteInstructor(id),
                       HttpStatus.OK,
                       LocalDateTime.now()
                )
        );
    }
}
