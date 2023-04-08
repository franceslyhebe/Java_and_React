package com.dio.studentsystem.service;

import com.dio.studentsystem.model.Student;import java.util.List;

public interface StudentService {
  public Student saveStudent(Student student);
  public List<Student> getAll();
}
