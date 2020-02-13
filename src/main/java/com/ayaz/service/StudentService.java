package com.ayaz.service;

import com.ayaz.domain.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "feignClient",url = "http://localhost:8082/")
public interface StudentService {

    @GetMapping(value = "students")
    List<Student> getStudentList();

    @GetMapping("/student/{id}")
    Student getStudentById(@PathVariable("id") String id);

    @PostMapping("/student")
    String createStudent(Student student);

    @DeleteMapping("/student/{id}")
    String deleteStudentById(@PathVariable("id") String id);

    @PutMapping("/updateAddress/{id}/{newAddress}")
    String uodateAddress(@PathVariable("id") String id, @PathVariable("newAddress") String newAddress);


}
