package com.rose.crud.enrollment.controller;

import com.rose.crud.course.entity.Course;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.enrollment.service.EnrollmentService;
import com.rose.crud.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

  public Enrollment addEnrollment(@RequestBody Enrollment enrollment){
      return enrollmentService.createEnrollment(enrollment);
  }

}
