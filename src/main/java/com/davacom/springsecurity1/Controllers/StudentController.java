package com.davacom.springsecurity1.Controllers;

import com.davacom.springsecurity1.Models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2,"Mary Johnson"),
            new Student(3,"Adam Smith")
    );

    @GetMapping("/all")
    public List<Student> getStudents(){
            return STUDENTS;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() ->new IllegalStateException("Student with Id "+studentId+ " does not exist"));
    }
}
