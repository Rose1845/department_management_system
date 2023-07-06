package com.rose.crud.student.service;

import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.student.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(StudentRequest studentRequest) {

        Student newStudent = Student.builder()
                .StudentName(studentRequest.getStudentName())
                .studentEmail(studentRequest.getStudentEmail())
                .enrollmentDate(studentRequest.getEnrollmentDate())
                .build();

        return studentRepository.save(newStudent);
    }
}
