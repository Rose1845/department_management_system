package com.rose.crud.repository;

import com.rose.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long> {

    public Student findByStudentId(Long studentId);
}
