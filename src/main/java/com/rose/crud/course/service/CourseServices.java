package com.rose.crud.course.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServices {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(CourseRequest courseRequest) {

        Course newCourse = Course.builder()
                .courseName(courseRequest.getCourseName())
                .build();

        return  courseRepository.save(newCourse);

    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public String deleteCourse(Long courseId) {
//       return courseRepository.deleteCourseByCourseId(courseId);
        courseRepository.deleteById(courseId);
        return "deleted successfully";
    }
}
