package com.rose.crud.teacher.repository;

import com.rose.crud.course.entity.Course;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.response.TeacherResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public Teacher findByTeacherId(Long teacherId);

}
