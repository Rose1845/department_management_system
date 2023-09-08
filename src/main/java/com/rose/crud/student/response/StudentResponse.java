package com.rose.crud.student.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rose.crud.guardian.Guardian;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class StudentResponse {

    private String StudentName;
    private String studentEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    private String course;
    private String guardianEmail;
    private String guardianLastName;
    private String guardianFirstName;
    private String phoneNumber;
}
