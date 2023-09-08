package com.rose.crud.student.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rose.crud.guardian.Guardian;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentRequest {

    private String StudentName;
    private String studentEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private String course;
    private String guardianFirstName;
    private String guardianLastName;
    private String phoneNumber;
    private String guardianEmail;
}
