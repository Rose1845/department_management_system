package com.rose.crud.course.controller;


import com.rose.crud.course.entity.Course;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.course.response.CourseResponse;
import com.rose.crud.course.service.CourseServices;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseServices courseServices;

    @PostMapping("")
    public CourseResponse createCourse(@RequestBody CourseRequest courseRequest ){
        return courseServices.createCourse(courseRequest);
    }
    @GetMapping("")
    public List<Course> getAllCourses(){
        return courseServices.getAllCourses();
    }
    @GetMapping("course")
    public Optional<Course> getCourseById(@RequestParam("id") Long courseId){
        return courseServices.getCourseById(courseId);
    }
    @GetMapping("students")
    public Optional<Course> getAllStudentsByCourseName(@RequestParam("courseName") String courseName){
        return courseServices.getAllStudentsByCourseName(courseName);
    }
    @DeleteMapping("course")
    public String deleteCourse(@RequestParam("id") Long courseId){

        return courseServices.deleteCourse(courseId);
    }

    @GetMapping("/students-by-course/{courseId}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Long courseId) {
        List<Student> students = courseServices.findStudentsByCourse(courseId);
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teachers-by-course/{courseId}")
    public ResponseEntity<List<Teacher>> getTeachersByCourse(@PathVariable Long courseId) {
        List<Teacher> students = courseServices.findTeachersByCourse(courseId);
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
