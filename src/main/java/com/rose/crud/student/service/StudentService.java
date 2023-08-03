package com.rose.crud.student.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.student.request.CreateStudentWithCourse;
import com.rose.crud.student.request.StudentRequest;
import com.rose.crud.student.response.StudentResponse;
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

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public String deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
        return "Student with " + studentId + "has been deleted";
    }

    public StudentResponse createStudentWithCourse(StudentRequest studentRequest) {

        Course course = courseRepository.findByCourseName(studentRequest.getCourse());

        Student student = new Student();
        student.setStudentEmail(studentRequest.getStudentEmail());
        student.setStudentName(studentRequest.getStudentName());
        student.setCourse(course);
        Student savedStudent = studentRepository.save(student);


        return StudentResponse.builder()
                 .StudentName(savedStudent.getStudentName())
                 .studentEmail(savedStudent.getStudentEmail())
                 .enrollmentDate(savedStudent.getEnrollmentDate())
                 .course(savedStudent.getCourse().getCourseName())
                 .build();
    }
}
