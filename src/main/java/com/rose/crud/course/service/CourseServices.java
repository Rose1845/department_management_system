package com.rose.crud.course.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.department.entity.Department;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.error.ApiRequestHandlerException;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.rose.crud.course.entity.Course.*;

@Service
@AllArgsConstructor
public class CourseServices {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public Course createCourse(CourseRequest courseRequest) {
        Course existingCourseName = courseRepository.findByCourseName(courseRequest.getCourseName());
        if(existingCourseName != null ){
            throw new ApiRequestHandlerException("Course already exist");
        }

        List<Student> students = studentRepository.findAll();

//        Department department = Department.builder()
//                .departmentAddress(courseRequest.getDepartmentRequest().getDepartmentAddress())
//                .departmentName(courseRequest.getDepartmentRequest().getDepartmentName())
//                .departmentCode(courseRequest.getDepartmentRequest().getDepartmentCode())
//                .build();
//
//        Teacher teacher = Teacher.builder()
//                .teacherEmail(courseRequest.getTeacherRequest().getTeacherEmail())
//                .teacherName(courseRequest.getTeacherRequest().getTeacherName())
//                .build();

        Course newCourse = builder()
                .courseName(courseRequest.getCourseName())
//                .teacher(teacher)
//                .department(department)
                .build();

        return  courseRepository.save(newCourse);

    }

    public List<Course> getAllCourses() {
        List<Student> students = new ArrayList<>(studentRepository.findAll());
        List<Teacher> teachers = new ArrayList<>(teacherRepository.findAll());

        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        List<Student> students = studentRepository.findAll();

        return courseRepository.findById(courseId);
    }

    public String deleteCourse(Long courseId) {
//       return courseRepository.deleteCourseByCourseId(courseId);
        courseRepository.deleteById(courseId);
        return "deleted successfully";
    }

    public Optional<Course> getAllStudentsByCourseName(String courseName) {
        return courseRepository.findAllStudentsByCourseName(courseName);
    }
}
