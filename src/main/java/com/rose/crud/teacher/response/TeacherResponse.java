package com.rose.crud.teacher.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TeacherResponse {
    private String teacherName;
    private String teacherEmail;
    private String course;
}
