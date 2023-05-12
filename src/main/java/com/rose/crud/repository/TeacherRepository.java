package com.rose.crud.repository;

import com.rose.crud.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public Teacher findByTeacherId(Long teacherId);
}
