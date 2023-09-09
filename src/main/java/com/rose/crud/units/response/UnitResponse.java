package com.rose.crud.units.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnitResponse {
    private String unitName;
    private String unitCode;
    private String creditHours;
    private String department;

}
