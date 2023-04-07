package com.dio.studentsystem.service;

import com.dio.studentsystem.model.Student;import com.dio.studentsystem.repository.StudentRepository;import org.springframework.beans.factory.annotation.Autowired;


public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
}
