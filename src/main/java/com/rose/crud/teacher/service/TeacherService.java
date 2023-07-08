package com.rose.crud.teacher.service;

import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.repository.TeacherRepository;
import com.rose.crud.teacher.request.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    public Teacher createTeacher(TeacherRequest teacherRequest) {

        Teacher newTeacher = Teacher.builder()
                .teacherName(teacherRequest.getTeacherName())
                .teacherEmail(teacherRequest.getTeacherEmail())
                .build();
        return teacherRepository.save(newTeacher);
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
