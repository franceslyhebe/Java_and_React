package com.dio.studentsystem.service;

import com.dio.studentsystem.model.Student;import java.util.List;
import org.springframework.http.ResponseEntity;

public interface StudentService {
  public Student saveStudent(Student student);
  public List<Student> getAll();
  public Student getById(Integer id);
  void deleteById(Integer id);

  ResponseEntity<Student> update(Student student, Integer id);
}
