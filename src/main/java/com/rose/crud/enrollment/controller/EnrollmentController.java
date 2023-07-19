package com.rose.crud.enrollment.controller;

import com.rose.crud.course.entity.Course;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.enrollment.service.EnrollmentService;
import com.rose.crud.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
@PostMapping("enrollments")
  public Enrollment addEnrollment(@RequestBody Enrollment enrollment){
      return enrollmentService.createEnrollment(enrollment);
  }

  @GetMapping("enrollments")
    public List<Enrollment> getAllEnrollment(){
    return enrollmentService.getAllEnrollments();
  }

}
