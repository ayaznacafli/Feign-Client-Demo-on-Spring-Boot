package com.ayaz.controller;

import com.ayaz.domain.Student;
import com.ayaz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RefreshScope
@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudentList();
    }


    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable("id") String id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/student")
    String createStudent(Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/student/{id}")
    String deleteStudentById(@PathVariable("id") String id){
        return studentService.deleteStudentById(id);
    }

    @PutMapping("/updateAddress/{id}/{newAddress}")
    String uodateAddress(@PathVariable("id") String id, @PathVariable("newAddress") String newAddress){
        return studentService.uodateAddress(id,newAddress);
    }

}
