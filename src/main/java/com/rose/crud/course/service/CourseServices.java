package com.rose.crud.course.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import com.rose.crud.course.response.CourseResponse;
import com.rose.crud.department.entity.Department;
import com.rose.crud.department.repository.DepartmentRepository;
import com.rose.crud.error.ApiRequestHandlerException;
import com.rose.crud.student.entity.Student;
import com.rose.crud.student.repository.StudentRepository;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.repository.TeacherRepository;
import lombok.AllArgsConstructor;
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
    private final DepartmentRepository departmentRepository;
    private final TeacherRepository teacherRepository;

    public CourseResponse createCourse(CourseRequest courseRequest) {
        Course existingCourseName = courseRepository.findByCourseName(courseRequest.getCourseName());
        if(existingCourseName != null ){
            throw new ApiRequestHandlerException("Course already exist");
        }
        Department department = departmentRepository.findDepartmentByDepartmentName(courseRequest.getDepartment());
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDepartment(department);

        Course savedCourse = courseRepository.save(course);

        return CourseResponse.builder()
                .courseName(savedCourse.getCourseName())
                .department(savedCourse.getDepartment().getDepartmentName())
                .build();
    }
    public List<Course> getAllCourses() {

        return courseRepository.findAll();
//                throw new ApiRequestHandlerException("Errot occured");
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "deleted successfully";
    }

    public Optional<Course> getAllStudentsByCourseName(String courseName) {
        return courseRepository.findAllStudentsByCourseName(courseName);
    }
}
