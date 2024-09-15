package com.javaDemo.student.service;

import com.javaDemo.student.model.dto.StudentDTO;

public interface StudentService {

    StudentDTO getStudentById(long id);

    Long addNewStudent(StudentDTO studentDTO);

    void deleteStudentById(long id);

}
