package com.kavya.kavya_springboot_session.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employeeTable")
@XmlRootElement
@Getter
@Setter
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
}
