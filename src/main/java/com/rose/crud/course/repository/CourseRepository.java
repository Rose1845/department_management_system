package com.rose.crud.course.repository;

import com.rose.crud.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByCourseName(String courseName);
    Optional<Course> deleteCourseByCourseId(Long courseId);
    Optional<Course> findAllStudentsByCourseName(String courseName);
}
