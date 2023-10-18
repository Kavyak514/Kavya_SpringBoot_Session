package com.kavya.kavya_springboot_session.service;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.Student;
import com.kavya.kavya_springboot_session.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public void setStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Response createStudent(Student student){Response response = new Response();
        Student student1 = studentRepository.save(student);
        response.setMessage("Successfully Inserted");
        response.setStatus("200");
        response.setStudent(student1);
        return response;
    }

    public String updateStudent(int id){
        String message = "";
        Optional<Student> exisitngStudednt = studentRepository.findById(id);
        if(exisitngStudednt.isPresent()){
            studentRepository.save(exisitngStudednt.get());
            message = "Student object updated successfully.";
        }else{
            message = "Student object not found.";
        }
        return message;
    }

    public Response getStudent(){
        Response response = new Response();
        response.setMessage("Successfully Retrieved");
        response.setStatus("200");
        response.setStudentList(studentRepository.findAll());
        return response;
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }
}
