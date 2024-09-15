package com.javaDemo.student.service.impl;

import com.javaDemo.student.converter.StudentConverter;
import com.javaDemo.student.model.dto.StudentDTO;
import com.javaDemo.student.model.entity.Student;
import com.javaDemo.student.repository.StudentRepository;
import com.javaDemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student =  studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        return StudentConverter.convertStudent(student);
        
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO){
        List<Student> studentList =  studentRepository.findByEmail(studentDTO.getEmail());

        if(!CollectionUtils.isEmpty(studentList)){
            throw new IllegalStateException("email:" + studentDTO.getEmail() + " has been taken");
        }

        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id){
        studentRepository.findById(id).orElseThrow(()-> new IllegalStateException("id:" + id + "doesn't exist!"));
        studentRepository.deleteById(id);
    }
}
