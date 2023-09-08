package com.rose.crud.teacher.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TeacherRequest {
    private String teacherName;
    private String teacherEmail;
    @Column(name = "course")
    private String course;
}
