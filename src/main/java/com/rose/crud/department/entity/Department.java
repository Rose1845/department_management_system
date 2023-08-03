package com.rose.crud.department.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@AllArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long departmentId;
    private String departmentCode;
    private String departmentAddress;
    private String departmentName;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    @JsonManagedReference
    private List<Course> courses;
}

