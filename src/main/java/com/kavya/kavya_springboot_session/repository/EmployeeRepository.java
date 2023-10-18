package com.kavya.kavya_springboot_session.repository;

import com.kavya.kavya_springboot_session.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}
