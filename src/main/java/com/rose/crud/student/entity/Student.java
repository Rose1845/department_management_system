package com.rose.crud.student.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.rose.crud.course.entity.Course;
import com.rose.crud.guardian.Guardian;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "course")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studentId;
    private String studentName;
//    @Column(name = "student_email")
    private String studentEmail;
//    @Column(name = "enrollment_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "guardianFirstName", column = @Column(name = "guardian_first_name")),
            @AttributeOverride(name = "guardianLastName", column = @Column(name = "guardian_last_name")),
            @AttributeOverride(name = "guardianEmail", column = @Column(name = "guardian_email")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "guardian_phone_number"))
    })
    private Guardian guardian;
}
