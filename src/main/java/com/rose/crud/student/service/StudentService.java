package com.rose.crud.student.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.enrollment.repository.EnrollmentRepository;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.student.request.CreateStudentWithCourse;
import com.rose.crud.student.request.StudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {

    private final  StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
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



    public Student createStudentWithCourse(CreateStudentWithCourse createStudentWithCourse) {
        Course course = Course.builder()
                .courseName(createStudentWithCourse.getCourseRequest().getCourseName())
                .students(studentRepository.findAll())
                .enrollments(enrollmentRepository.findAll())
                .build();
        Student student = Student.builder()
                .course(course)
                .studentName(createStudentWithCourse.getStudentRequest().getStudentName())
                .studentEmail(createStudentWithCourse.getStudentRequest().getStudentEmail())
                .enrollmentDate(createStudentWithCourse.getStudentRequest().getEnrollmentDate())
                .build();

        return studentRepository.save(student);


    }
}
