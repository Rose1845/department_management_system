package com.rose.crud.enrollment.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.enrollment.repository.EnrollmentRepository;
import com.rose.crud.student.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    public Enrollment createEnrollment(Enrollment enrollment) {

         return enrollmentRepository.save(enrollment);

    }
}
