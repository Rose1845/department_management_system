package com.rose.crud.teacher.controller;

import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.request.TeacherRequest;
import com.rose.crud.teacher.response.TeacherResponse;
import com.rose.crud.teacher.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("")
    public TeacherResponse createTeacher(@RequestBody TeacherRequest teacherRequest){
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
