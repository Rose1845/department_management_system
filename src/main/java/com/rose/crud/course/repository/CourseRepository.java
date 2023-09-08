package com.rose.crud.course.repository;

import com.rose.crud.course.entity.Course;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByCourseName(String courseName);
    Optional<Course> deleteCourseByCourseId(Long courseId);
    Optional<Course> findAllStudentsByCourseName(String courseName);

    @Query("SELECT c.student FROM Course c WHERE c.courseId = :courseId")
    List<Student> findStudentsByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT c.teachers FROM Course c WHERE c.courseId = :courseId")
    List<Teacher> findTeachersByCourseId(@Param("courseId") Long courseId);

}
