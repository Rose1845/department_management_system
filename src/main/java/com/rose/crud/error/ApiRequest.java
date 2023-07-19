package com.rose.crud.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiRequest {

    private HttpStatus httpStatus;
    private String message;
    private Throwable throwable;
}
