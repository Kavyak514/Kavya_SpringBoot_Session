package com.kavya.kavya_springboot_session;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "employeeTable")
@XmlRootElement
public class Employee {
    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    @XmlElement
    private double salary;
    @XmlElement
    private String companyName;
    @XmlElement
    private String companyNames;

    public String getCompanyNames() {
        return companyNames;
    }

    public void setCompanyNames(String companyNames) {
        this.companyNames = companyNames;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
