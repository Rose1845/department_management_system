package com.rose.crud.department.service;


import com.rose.crud.course.entity.Course;
import com.rose.crud.department.entity.Department;
import com.rose.crud.department.repository.DepartmentRepository;
import com.rose.crud.department.request.DepartmentRequest;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentRequest departmentRequest){
        Department newDepartment = Department.builder()
                .departmentCode(departmentRequest.getDepartmentCode())
                .departmentAddress(departmentRequest.getDepartmentAddress())
                .departmentName(departmentRequest.getDepartmentName())
                .build();
        return departmentRepository.save(newDepartment);
    }

    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public List<Department> getAllDepartments() {
        return  departmentRepository.findAll();
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public String getDepartmentByName(String departmentName) {
        departmentRepository.findDepartmentByDepartmentName(departmentName);
        return departmentName;
    }
    public List<Course> findCoursesByDepartment(Long departmentId) {
        return departmentRepository.findCoursesByDepartmentId(departmentId);
    }

    public List<Student> findStudentsByCourseInDepartment(Long departmentId, String courseName) {
        return departmentRepository.findStudentsByCourseInDepartment(departmentId, courseName);
    }
    public List<Teacher> findTeachersByCourseInDepartment(Long departmentId, String courseName) {
        return departmentRepository.findTeachersByCourseInDepartment(departmentId, courseName);
    }


}


