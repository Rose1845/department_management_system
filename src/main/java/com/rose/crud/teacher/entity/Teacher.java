package com.rose.crud.teacher.entity;

import com.rose.crud.course.entity.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.util.List;
@Entity
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;
    @Column(name = "teacher_email",unique = true)
    private String teacherEmail;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;

}
