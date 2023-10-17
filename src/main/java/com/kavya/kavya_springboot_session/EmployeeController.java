package com.kavya.kavya_springboot_session;

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

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/getEmployeeXmlFormat", produces = {"application/xml", "text/xml"}, consumes = MediaType.ALL_VALUE)
    public List<Employee> getEmployeeXmlFormat() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PatchMapping("/updatePartialEmployee")
    public Employee updatePartialEmployee(@RequestBody Employee employee) {
        return employeeService.updatePartialEmployee(employee);
    }

    @PatchMapping("/updatePartialEmployeeData/{id}")
    public Employee updatePartialEmployeeData(@PathVariable String id, @RequestBody Map<String, Object> map) {
        return employeeService.updatePartialEmployeeData(id, map);
    }
}
