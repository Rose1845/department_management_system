package com.rose.crud.course.entity;

import com.rose.crud.department.entity.Department;
import com.rose.crud.enrollment.entity.Enrollment;
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
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @OneToMany
    private List<Student> students;


}
