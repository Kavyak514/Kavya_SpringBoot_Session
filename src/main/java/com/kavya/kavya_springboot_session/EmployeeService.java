package com.kavya.kavya_springboot_session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    //IOC :- INVERSION OF CONTROL
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> saveEmployee(){
        return employeeRepository.findAll();
    }
}
