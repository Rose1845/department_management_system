package com.rose.crud.teacher.repository;

import com.rose.crud.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public Teacher findByTeacherId(Long teacherId);
}
