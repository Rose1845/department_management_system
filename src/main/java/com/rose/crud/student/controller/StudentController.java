package com.rose.crud.student.controller;

import com.rose.crud.student.entity.Student;
import com.rose.crud.student.request.StudentRequest;
import com.rose.crud.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student createStudent(@RequestBody StudentRequest studentRequest){




        return  studentService.createStudent(studentRequest);
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
