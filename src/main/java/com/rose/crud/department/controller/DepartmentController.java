package com.rose.crud.department.controller;


import com.rose.crud.course.entity.Course;
import com.rose.crud.department.request.DepartmentRequest;
import com.rose.crud.department.service.DepartmentService;
import com.rose.crud.department.entity.Department;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody DepartmentRequest departmentRequest){
        return departmentService.createDepartment(departmentRequest);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "deleted successfully";

    }
    @GetMapping("/department/name")
    public String getDepartmentByName(@RequestParam("name") String departmentName){
       return departmentService.getDepartmentByName(departmentName);
    }
    @GetMapping("/courses-by-department/{departmentId}")
    public ResponseEntity<List<Course>> getCoursesByDepartment(@PathVariable Long departmentId) {
        List<Course> courses = departmentService.findCoursesByDepartment(departmentId);
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/students-by-course-in-department")
    public ResponseEntity<List<Student>> getStudentsByCourseInDepartment(
            @RequestParam(value = "departmentId") Long departmentId,
            @RequestParam(value = "courseName") String courseName
    ) {
        List<Student> students = departmentService.findStudentsByCourseInDepartment(departmentId, courseName);
        if (!students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/teachers-by-course-in-department")
//    @PreAuthorize(value = "hasAnyRole('ADMIN','MANAGER')")
    public ResponseEntity<List<Teacher>> getTeachersByCourseInDepartment(
            @RequestParam(value = "departmentId") Long departmentId,
            @RequestParam(value = "courseName") String courseName
    ) {
        List<Teacher> teachers = departmentService.findTeachersByCourseInDepartment(departmentId, courseName);
        if (!teachers.isEmpty()) {
            return ResponseEntity.ok(teachers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

