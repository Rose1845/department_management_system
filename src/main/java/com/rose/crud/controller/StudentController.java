package com.rose.crud.controller;

import com.rose.crud.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return  null;
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return null;
    }
    @GetMapping("/students/{id}")

    public Optional<Student> getStudent(@PathVariable("id") Long studentId){
        return null;
    }
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long studentId){
        return "deteleted succesfully";
    }

}
