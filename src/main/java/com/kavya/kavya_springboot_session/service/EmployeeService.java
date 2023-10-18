package com.kavya.kavya_springboot_session.service;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.Employee;
import com.kavya.kavya_springboot_session.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeService {
    //IOC :- INVERSION OF CONTROL

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Response saveEmployee(Employee employee) {
        Response response = new Response();
        Employee employee1 = employeeRepository.save(employee);
        response.setMessage("Successfully Inserted");
        response.setStatus("200");
        response.setEmployee(employee1);
        return response;
    }

    public Iterable<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Successfully Deleted";
        } else {
            return "The Id doesn't exist";
        }
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
            return employeeRepository.save(employee);
        } else {
            return new Employee();
        }
    }

    public Employee updatePartialEmployee(Employee employee) {
        Optional<Employee> employee2 = employeeRepository.findById(employee.getEmployeeId());
        if (employee2.isPresent()) {
            Employee employee1 = employee2.get();
            if (employee.getSalary() != 0) {
                employee1.setSalary(employee.getSalary());
            }
            if (employee.getCompanyNames() != null) {
                employee1.setCompanyNames(employee.getCompanyNames());
            }
            if (employee.getCompanyName() != null) {
                employee1.setCompanyName(employee.getCompanyName());
            }
            return employeeRepository.save(employee1);
        }
        return employee;
    }

    public Employee updatePartialEmployeeData(int id, Map<String, Object> map) {
        Optional<Employee> employee2 = employeeRepository.findById(id);
        if (employee2.isPresent()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                Field field = ReflectionUtils.findField(Employee.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, employee2.get(), value);
            }
            return employeeRepository.save(employee2.get());
        }
        return null;
    }

    public Employee findBySalary(double salary){
        return employeeRepository.findBySalary(salary);
    }

    public List<Employee> findSortedEmployeeBySalary(){
        return employeeRepository.findSortedEmployeeBySalary();
    }
}
