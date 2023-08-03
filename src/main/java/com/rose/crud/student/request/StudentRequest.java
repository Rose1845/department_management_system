package com.rose.crud.student.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentRequest {

    private String StudentName;
    private String studentEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private String course;
}
