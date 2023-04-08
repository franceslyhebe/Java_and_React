package com.dio.studentsystem.service;

import com.dio.studentsystem.model.Student;import com.dio.studentsystem.repository.StudentRepository;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

}
