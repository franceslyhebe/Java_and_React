package com.dio.studentsystem.controller;

import com.dio.studentsystem.model.Student;
import com.dio.studentsystem.service.StudentService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentService.saveStudent(student);

        return "New student is added";
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id){
        try{
            Student student = studentService.getById(id);
      return new ResponseEntity<>(student, HttpStatus.OK);

        }catch(NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id){
        try{
            Student existingStudent = studentService.getById(id);
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());

            studentService.saveStudent(existingStudent);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch( NoSuchElementException e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
        public String delete(@PathVariable Integer id){
            studentService.deleteById(id);
            return "Deleted Student with id: " + id;

        }
}
