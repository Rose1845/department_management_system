package com.rose.crud.student.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rose.crud.course.entity.Course;
import com.rose.crud.course.request.CourseRequest;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateStudentWithCourse {

    private StudentRequest studentRequest;
    private CourseRequest courseRequest;
}
