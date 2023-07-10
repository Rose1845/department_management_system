package com.rose.crud.course.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rose.crud.department.entity.Department;
import com.rose.crud.enrollment.entity.Enrollment;
import com.rose.crud.student.entity.Student;
import com.rose.crud.teacher.entity.Teacher;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name="courses")
@Builder
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseName;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;
    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students;

    public Course(Long courseId, String courseName, Teacher teacher, List<Enrollment> enrollments, Department department, List<Student> students) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.enrollments = enrollments;
        this.department = department;
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return Objects.equals(students, course.students);
    }


    @Override
    public int hashCode() {
        return Objects.hash(students);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
}