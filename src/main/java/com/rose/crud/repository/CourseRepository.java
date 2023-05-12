package com.rose.crud.repository;

import com.rose.crud.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    public Course findByCourseName(Long courseName);
}
