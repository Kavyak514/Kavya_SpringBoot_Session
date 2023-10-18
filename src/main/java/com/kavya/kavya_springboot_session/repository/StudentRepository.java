package com.kavya.kavya_springboot_session.repository;

import com.kavya.kavya_springboot_session.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
