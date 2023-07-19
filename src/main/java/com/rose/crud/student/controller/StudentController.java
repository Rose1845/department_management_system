package com.rose.crud.student.controller;

import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.request.CreateStudentWithCourse;
import com.rose.crud.student.request.StudentRequest;
import com.rose.crud.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final  StudentService studentService;

    @PostMapping("")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return  studentService.createStudent(studentRequest);
    }
    @PostMapping("create-student-course")
    public Student createStudentWithCourse(@RequestBody CreateStudentWithCourse createStudentWithCourse){
        return studentService.createStudentWithCourse(createStudentWithCourse);
    }
    @GetMapping("")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }
    @GetMapping("student")
    public Optional<Student> getStudent(@RequestParam("id") Long studentId){
        return studentService.getStudentById(studentId);
    }
    @DeleteMapping("student")
    public String deleteStudent(@RequestParam("id") Long studentId){
        return studentService.deleteStudent(studentId);
    }

}
