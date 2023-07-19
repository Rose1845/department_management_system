package com.rose.crud.teacher.entity;

import com.rose.crud.course.entity.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long teacherId;
    private String teacherName;
    private String teacherEmail;
    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;


}
