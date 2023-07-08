package com.rose.crud.student.repository;

import com.rose.crud.course.entity.Course;
import com.rose.crud.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {

    public Student findByStudentId(Long studentId);

    Optional<Student> deleteStudentByStudentId(Long studentId);

}
