package com.kavya.kavya_springboot_session.controller;

import com.kavya.kavya_springboot_session.Service.StudentService;
import com.kavya.kavya_springboot_session.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/createStudent")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(student, id);
    }

    @GetMapping("/getStudent")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }
}
