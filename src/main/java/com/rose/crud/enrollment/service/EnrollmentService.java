package com.rose.crud.enrollment.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.enrollment.repository.EnrollmentRepository;
import com.rose.crud.student.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    public Enrollment createEnrollment(Enrollment enrollment) {

         return enrollmentRepository.save(enrollment);

    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }
}
