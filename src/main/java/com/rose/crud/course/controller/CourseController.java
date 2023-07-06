package com.rose.crud.course.controller;


import com.rose.crud.course.entity.Course;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.course.service.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @PostMapping("/create-course")
    public Course createCourse(@RequestBody CourseRequest courseRequest ){
        return courseServices.createCourse(courseRequest);

    }
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return null;

    }
    @GetMapping("courses/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long courseId){
        return null;


    }
    @DeleteMapping("/courses/{id}")
    public String deleteCourse(@PathVariable("id") Long courseId){
        return"deleted successfully";
    }


}
