package com.rose.crud.student.service;

import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.student.request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public Student createStudent(StudentRequest studentRequest) {

        Student newStudent = Student.builder()
                .studentName(studentRequest.getStudentName())
                .studentEmail(studentRequest.getStudentEmail())
                .enrollmentDate(studentRequest.getEnrollmentDate())
                .build();

        return studentRepository.save(newStudent);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public String deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student with " + studentId + "has been deleted";
    }
}
