package com.rose.crud.controller;

import com.rose.crud.entity.Student;
import com.rose.crud.entity.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    @PostMapping("/teachers")
    public Student createTeacher(@RequestBody Teacher teacher){
        return  null;
    }
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){
        return null;
    }
    @GetMapping("/teachers/{id}")

    public Optional<Teacher> getTeacher(@PathVariable("id") Long teacherId){
        return null;
    }
    @DeleteMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable("id") Long teacherId){
        return "deteleted succesfully";
    }

}
