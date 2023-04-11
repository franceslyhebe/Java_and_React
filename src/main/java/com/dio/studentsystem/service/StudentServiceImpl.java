package com.dio.studentsystem.service;

import com.dio.studentsystem.model.Student;import com.dio.studentsystem.repository.StudentRepository;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.stereotype.Service;

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
    @Override
    public Student getById(Integer id){
        return studentRepository.findById(id).get();
    }
    @Override
    public void deleteById(Integer id){
        studentRepository.deleteById(id);
    }
   @Override
   public ResponseEntity<Student> update(Student student, Integer id) {
        student = studentRepository.getById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

}
