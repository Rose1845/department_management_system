package com.rose.crud.student.controller;

import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.student.request.StudentRequest;
import com.rose.crud.student.response.StudentResponse;
import com.rose.crud.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class StudentController {

    private final  StudentService studentService;
    @PostMapping("create-student-course")
    public StudentResponse createStudentWithCourse(@RequestBody StudentRequest studentRequest){
        return studentService.createStudentWithCourse(studentRequest);
    }
    @GetMapping
    public List<Student> printAllStudents(){
        return studentService.getALlStudents();
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
