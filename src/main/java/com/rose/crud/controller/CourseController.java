package com.rose.crud.controller;


import com.rose.crud.entity.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CourseController {

    @PostMapping("/create-course")
    public Course createCourse(@RequestBody Course course ){
        return  course;

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
