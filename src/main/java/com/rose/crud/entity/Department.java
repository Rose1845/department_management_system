package com.rose.crud.entity;



import jakarta.persistence.*;

@Entity
@Table (name=("departments"))
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long departmentId;
    private String departmentCode;
    private String departmentAddress;
    private String departmentName;

    public Department() {
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Department(Long departmentId, String departmentCode, String departmentAddress, String departmentName) {
        this.departmentId = departmentId;
        this.departmentCode = departmentCode;
        this.departmentAddress = departmentAddress;
        this.departmentName = departmentName;
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

