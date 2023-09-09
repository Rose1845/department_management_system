package com.rose.crud.units.controller;

import com.rose.crud.units.requests.UnitRequest;
import com.rose.crud.units.response.UnitResponse;
import com.rose.crud.units.service.UnitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/units")
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping("create-a-unit")
    public UnitResponse createUnit(@RequestBody UnitRequest unitRequest){
        return unitService.createUnit(unitRequest);
    }
}
