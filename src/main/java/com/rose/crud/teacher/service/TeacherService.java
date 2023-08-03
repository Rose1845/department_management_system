package com.rose.crud.teacher.service;

import com.rose.crud.course.entity.Course;
import com.rose.crud.course.repository.CourseRepository;
import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.repository.TeacherRepository;
import com.rose.crud.teacher.request.TeacherRequest;
import com.rose.crud.teacher.response.TeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;
    public TeacherResponse createTeacher(TeacherRequest teacherRequest) {

        Course course = courseRepository.findByCourseName(teacherRequest.getCourse());

        Teacher savedTeacher = new Teacher();
        savedTeacher.setTeacherEmail(teacherRequest.getTeacherEmail());
        savedTeacher.setTeacherName(teacherRequest.getTeacherName());
        savedTeacher.setCourse(course);

        Teacher teacher = teacherRepository.save(savedTeacher);

        return  TeacherResponse.builder()
                .teacherName(teacher.getTeacherName())
                .teacherEmail(teacher.getTeacherEmail())
                 .course(teacher.getCourse().getCourseName())
                .build();

    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public String getTeacherById(Long teacherId) {
        teacherRepository.findById(teacherId);
        return "success";
    }

    public String deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
        return "Teacher with "+ teacherId + "has been deleted";
    }
}
