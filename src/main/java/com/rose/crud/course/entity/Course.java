package com.rose.crud.course.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "department_id",referencedColumnName = "departmentId")
    @JsonBackReference
    private Department department;
    @OneToOne(mappedBy = "course")
    @JsonIgnore
    @JsonManagedReference
    private Student student;
}
