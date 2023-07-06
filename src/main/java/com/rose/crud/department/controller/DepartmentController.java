package com.rose.crud.department.controller;


import com.rose.crud.department.request.DepartmentRequest;
import com.rose.crud.department.service.DepartmentService;
import com.rose.crud.department.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody DepartmentRequest departmentRequest){
        return departmentService.createDepartment(departmentRequest);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "deleted successfully";

    }
    @GetMapping("/department/name/{name}")
    public String getDepartmentByName(@PathVariable("name") String departmentName){
       return departmentService.getDepartmentByName(departmentName);
    }

}

