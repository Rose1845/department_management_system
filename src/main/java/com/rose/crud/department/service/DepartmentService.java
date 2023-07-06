package com.rose.crud.department.service;


import com.rose.crud.department.entity.Department;
import com.rose.crud.department.repository.DepartmentRepository;
import com.rose.crud.department.request.DepartmentRequest;
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
        departmentRepository.findByDepartmentName(departmentName);
        return departmentName;
    }
}


