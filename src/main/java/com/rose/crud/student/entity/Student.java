package com.rose.crud.student.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rose.crud.course.entity.Course;
import com.rose.crud.enrollment.entity.Enrollment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Builder
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long studentId;
    private String studentName;
    private String studentEmail;
    @Column(name = "enrollment_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;
    @OneToMany(mappedBy="student")

    private List<Enrollment> enrollments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(
                    name = "student_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id"
            )
    )
    private List<Course> courses;

    public Student(Long studentId, String studentName, String studentEmail, LocalDate enrollmentDate, List<Enrollment> enrollments, List<Course> courses) {
        this.studentId = studentId;
        studentName = studentName;
        this.studentEmail = studentEmail;
        this.enrollmentDate = enrollmentDate;
        this.enrollments = enrollments;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courses);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long id) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
