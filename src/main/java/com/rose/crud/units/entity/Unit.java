package com.rose.crud.units.entity;

import com.rose.crud.department.entity.Department;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;
    private String unitName;
    private String unitCode;
    private String creditHours;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
