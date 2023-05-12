package com.rose.crud.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "enrollment_date")

    private LocalDate enrollmentDate;

    public Enrollment(Long enrollmentId, Student student, Course course, LocalDate enrollmentDate) {
        this.enrollmentId= enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long id) {
        this.enrollmentId= enrollmentId;
    }


    @ManyToOne
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
