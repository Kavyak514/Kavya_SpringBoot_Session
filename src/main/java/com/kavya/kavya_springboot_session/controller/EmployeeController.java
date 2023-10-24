package com.kavya.kavya_springboot_session.controller;

import com.kavya.kavya_springboot_session.dto.Response;
import com.kavya.kavya_springboot_session.entity.Employee;
import com.kavya.kavya_springboot_session.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee/saveEmployee")
    public Response saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/getEmployee")
    public Iterable<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/employee/getEmployeeXmlFormat", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public Iterable<Employee> getEmployeeXmlFormat() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/employee/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PatchMapping("/employee/updatePartialEmployee")
    public Employee updatePartialEmployee(@RequestBody Employee employee) {
        return employeeService.updatePartialEmployee(employee);
    }

    @PatchMapping("/updatePartialEmployeeData/{id}")
    public Employee updatePartialEmployeeData(@PathVariable int id, @RequestBody Map<String, Object> map) {
        return employeeService.updatePartialEmployeeData(id, map);
    }

    @GetMapping("/findBySalary/{salary}")
    public Employee findBySalary(@PathVariable double salary) {
        return employeeService.findBySalary(salary);
    }

    @GetMapping("/getSortedEmployeeBySalary")
    public List<Employee> findSortedEmployeeBySalary() {
        return employeeService.findSortedEmployeeBySalary();
    }
}