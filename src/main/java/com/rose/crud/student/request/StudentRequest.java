package com.rose.crud.student.request;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentRequest {

    private String StudentName;
    private String studentEmail;
    private LocalDate enrollmentDate;
}
