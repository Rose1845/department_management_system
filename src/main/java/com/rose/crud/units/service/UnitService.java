package com.rose.crud.units.service;

import com.rose.crud.department.entity.Department;
import com.rose.crud.department.repository.DepartmentRepository;
import com.rose.crud.units.entity.Unit;
import com.rose.crud.units.repository.UnitRepository;
import com.rose.crud.units.requests.UnitRequest;
import com.rose.crud.units.response.UnitResponse;
import org.springframework.stereotype.Service;

@Service
public class UnitService {
    private final UnitRepository unitRepository;
    private  final DepartmentRepository departmentRepository;

    public UnitService(UnitRepository unitRepository, DepartmentRepository departmentRepository) {
        this.unitRepository = unitRepository;
        this.departmentRepository = departmentRepository;
    }

    public UnitResponse createUnit(UnitRequest unitRequest){
        Unit unit = unitRepository.findByUnitName(unitRequest.getUnitName());


        Unit unit1 = Unit.builder().build();
        unit1.setUnitCode(unitRequest.getUnitCode());
        unit1.setUnitName(unitRequest.getUnitName());
        unit1.setCreditHours(unitRequest.getCreditHours());
        Department department = departmentRepository.findDepartmentByDepartmentName(unitRequest.getDepartment());
        unit1.setDepartment(department);


        Unit unit2 = unitRepository.save(unit1);

        return UnitResponse.builder()
                .unitName(unit2.getUnitName())
                .unitCode(unit2.getUnitCode())
                .creditHours(unit2.getCreditHours())
                .department(unit2.getDepartment().getDepartmentName())
                .build();
    }

}
