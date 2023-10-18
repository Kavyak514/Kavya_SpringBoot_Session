package com.kavya.kavya_springboot_session.Service;

import com.kavya.kavya_springboot_session.model.Student;
import com.kavya.kavya_springboot_session.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public void setStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public String updateStudent(Student student, int id){
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

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }
}
