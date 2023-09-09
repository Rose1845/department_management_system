package com.rose.crud.department.repository;

import com.rose.crud.course.entity.Course;
import com.rose.crud.department.entity.Department;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findDepartmentByDepartmentName(String departmentName);

    @Query("SELECT d.courses FROM Department d WHERE d.departmentId = :departmentId")
    List<Course> findCoursesByDepartmentId(@Param("departmentId") Long departmentId);

    @Query("SELECT s FROM Department d JOIN d.courses c JOIN c.student s WHERE d.departmentId = :departmentId AND c.courseName = :courseName")
    List<Student> findStudentsByCourseInDepartment(@Param("departmentId") Long departmentId, @Param("courseName") String courseName);

    @Query("SELECT t FROM Department d JOIN d.courses c JOIN c.teachers t WHERE d.departmentId = :departmentId AND c.courseName = :courseName")
    List<Teacher> findTeachersByCourseInDepartment(@Param("departmentId") Long departmentId, @Param("courseName") String courseName);


}
