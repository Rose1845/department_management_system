package com.rose.crud.student.repository;

import com.rose.crud.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {

    public Student findByStudentId(Long studentId);
}
