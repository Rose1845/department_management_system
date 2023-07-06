package com.rose.crud.course.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.course.request.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServices {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(CourseRequest courseRequest) {

        Course course = Course.builder()
                .courseName(courseRequest.getCourseName())
                .build();

        return  courseRepository.save(course);

    }
}
