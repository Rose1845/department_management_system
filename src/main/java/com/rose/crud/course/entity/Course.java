package com.rose.crud.course.entity;

import com.rose.crud.department.entity.Department;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="courses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="teacher_id",
    referencedColumnName = "teacherId")
    private Teacher teacher;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",referencedColumnName = "departmentId")
    private Department department;
    @OneToOne(mappedBy = "course")
    private Student student;


}
