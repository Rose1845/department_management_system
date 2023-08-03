package com.rose.crud.teacher.request;

import lombok.Data;

@Data
public class TeacherRequest {
    private String teacherName;
    private String teacherEmail;
    private String course;
}
