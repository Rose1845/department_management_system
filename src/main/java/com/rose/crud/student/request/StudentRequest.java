package com.rose.crud.student.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentRequest {

    private String StudentName;
    private String studentEmail;
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
}
