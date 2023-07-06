package com.rose.crud.teacher.controller;

import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.request.TeacherRequest;
import com.rose.crud.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody TeacherRequest teacherRequest){



        return  teacherService.createTeacher(teacherRequest);
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
