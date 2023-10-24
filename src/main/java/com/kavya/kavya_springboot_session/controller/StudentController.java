package com.kavya.kavya_springboot_session.controller;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.Student;
import com.kavya.kavya_springboot_session.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {
    StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/createStudent")
    public Response createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/student/updateStudent/{id}")
    public String updateStudent(@PathVariable int id) {
        return studentService.updateStudent(id);
    }

    @GetMapping("/student/getStudent")
    public Response getStudent() {
        return studentService.getStudent();
    }

    @GetMapping("/student/getStudentById/{id}")
    public Student getStudent(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.orElse(null);
    }
}
