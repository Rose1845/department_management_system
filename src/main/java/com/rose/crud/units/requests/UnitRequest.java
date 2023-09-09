package com.rose.crud.units.requests;

import lombok.Data;

@Data
public class UnitRequest {
    private String unitName;
    private String unitCode;
    private String creditHours;
    private String department;
}
