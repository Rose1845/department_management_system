package com.rose.crud.teacher.controller;

import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.request.TeacherRequest;
import com.rose.crud.teacher.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @PostMapping("")
    public Teacher createTeacher(@RequestBody TeacherRequest teacherRequest){



        return  teacherService.createTeacher(teacherRequest);
    }
    @GetMapping("")
    public List<Teacher> getAllTeachers(){

        return teacherService.getAllTeachers();
    }
    @GetMapping("teacher")

    public String getTeacher(@RequestParam("id") Long teacherId){

        return teacherService.getTeacherById(teacherId);
    }
    @DeleteMapping("teacher")
    public String deleteTeacher(@RequestParam("id") Long teacherId){

        return teacherService.deleteTeacher(teacherId);
    }

}
