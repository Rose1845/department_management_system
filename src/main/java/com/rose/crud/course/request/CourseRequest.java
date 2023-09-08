package com.rose.crud.course.request;

import com.rose.crud.department.entity.Department;
import com.rose.crud.department.request.DepartmentRequest;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.request.TeacherRequest;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class CourseRequest {
    private String courseName;
    private String department;
}
