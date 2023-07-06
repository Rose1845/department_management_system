package com.rose.crud.department.entity;



import com.rose.crud.course.entity.Course;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@Table (name=("departments"))
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long departmentId;
    private String departmentCode;
    private String departmentAddress;
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Course> courses;

    public Department(Long departmentId, String departmentCode, String departmentAddress, String departmentName, List<Course> courses) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
        this.departmentName = departmentName;
        this.courses = courses;
    }

    public Long getDepartmentId() {
        return departmentId;
    }



    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}

