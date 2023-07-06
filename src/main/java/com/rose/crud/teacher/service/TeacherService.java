package com.rose.crud.teacher.service;

import com.rose.crud.teacher.entity.Teacher;
import com.rose.crud.teacher.repository.TeacherRepository;
import com.rose.crud.teacher.request.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
