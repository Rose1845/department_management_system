package com.rose.crud.course.request;

import com.rose.crud.department.request.DepartmentRequest;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.request.TeacherRequest;
import lombok.Data;

import java.util.List;

@Data
public class CourseRequest {

    private String courseName;
//    private List<Enrollment> enrollments;
//    private List<Student> students;
//    private DepartmentRequest departmentRequest;
//    private TeacherRequest teacherRequest;
}
