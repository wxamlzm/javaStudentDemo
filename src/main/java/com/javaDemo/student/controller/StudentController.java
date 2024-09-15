package com.javaDemo.student.controller;

import com.javaDemo.student.Response;
import com.javaDemo.student.model.dto.StudentDTO;
import com.javaDemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public Response<StudentDTO> getStudentById(@PathVariable long id){
        return Response.newSuccess(studentService.getStudentById(id));
    }

    @PostMapping("/student")
    public Response<Long>  addNewStudent(@RequestBody StudentDTO studentDTo){
        return Response.newSuccess(studentService.addNewStudent(studentDTo));
    }

    @DeleteMapping("/student/{id}")
    public void deldteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
    }
}
