package com.davacom.springsecurity1.Controllers;

import com.davacom.springsecurity1.Models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1,"James Bond"),
            new Student(2,"Mary Johnson"),
            new Student(3,"Adam Smith")
    );

    @GetMapping
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN,','ROLE_ADMIN-TRAINEE')")
    public List<Student> getAllStudents(){
        System.out.println("Get all student");
            return STUDENTS;
        }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() ->new IllegalStateException("Student with Id "+studentId+ " does not exist"));
    }

        @PostMapping("register")
//        @PreAuthorize("hasAuthority(' student:write ')")
        public void registerNewStudent(@RequestBody  Student student){
            System.out.println("registered new student");
        System.out.println(student);
        }


        @DeleteMapping(path="delete/{studentId}")
//        @PreAuthorize("hasAuthority('student:write')")
        public void deleteStudent(@PathVariable("studentId") Integer  studentId){
            System.out.println("deleted student");
        System.out.println(studentId);
        }


        @PutMapping(path ="update/{studentId}")
//        @PreAuthorize("hasAuthority('student:write')")
        public void updateStudent(@PathVariable("studentId") Integer  studentId , @RequestBody Student student) {
            System.out.println("updated student info");
        System.out.println(String.format("%s  %s", studentId, student));
        }
}
