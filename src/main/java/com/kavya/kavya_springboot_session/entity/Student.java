package com.kavya.kavya_springboot_session.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "StudentDetails")
@Getter
@Setter
public class Student {
    @Id
    private int sid;
    private String sName;
    private String collegeId;
}
