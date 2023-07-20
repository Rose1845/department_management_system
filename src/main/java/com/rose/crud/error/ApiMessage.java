package com.rose.crud.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiMessage {
  @ExceptionHandler(value = {ApiRequestHandlerException.class})
    public ResponseEntity<Object> errorMessage(ApiRequestHandlerException apiRequestHandlerException){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiRequest apiRequest = ApiRequest.builder()
                .message(apiRequestHandlerException.getMessage())
                .httpStatus(badRequest)
                .throwable(apiRequestHandlerException.getCause())
                .build();

        return new ResponseEntity<>(apiRequest,badRequest);

    }

//    @ExceptionHandler(value = {ApiRequestHandlerException.class})
//    public ResponseEntity<Object> notFoundMessage(ApiRequestHandlerException apiRequestHandlerException){
//        HttpStatus badRequest = HttpStatus.NOT_FOUND;
//        ApiRequest apiRequest = ApiRequest.builder()
//                .message(apiRequestHandlerException.getMessage())
//                .httpStatus(badRequest)
//                .throwable(apiRequestHandlerException.getCause())
//                .build();
//
//        return new ResponseEntity<>(apiRequest,badRequest);
//
//    }


}
