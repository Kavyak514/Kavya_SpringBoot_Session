package com.kavya.kavya_springboot_session.dto;

import com.kavya.kavya_springboot_session.entity.Employee;
import com.kavya.kavya_springboot_session.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Response {
    private String status;
    private String message;
    private Employee employee;
    private Student student;
    private List<Student> studentList;
}
