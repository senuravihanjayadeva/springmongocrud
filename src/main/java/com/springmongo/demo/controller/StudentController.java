package com.springmongo.demo.controller;

import com.springmongo.demo.model.StudentDTO;
import com.springmongo.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    //Get Single Student
    @GetMapping("/students/{id}")
    public ResponseEntity<?> getSingleStudent(@PathVariable String id){

       Optional<StudentDTO> student =  studentRepo.findById(id);
       if(student.isPresent()){
           return new ResponseEntity<>(student.get(),HttpStatus.OK);
       }else{
           return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
       }

    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(){
        List<StudentDTO> students = studentRepo.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<StudentDTO>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createstudent")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO student){
        try{
            student.setCreatedAt(new Date(System.currentTimeMillis()));
            studentRepo.save(student);
            return new ResponseEntity<StudentDTO>(student, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
