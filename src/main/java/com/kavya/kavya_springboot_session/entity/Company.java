package com.kavya.kavya_springboot_session.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "companyTable")
@Getter
@Setter
public class Company {
    @Id
    private String companyId;
    private String companyName;
}
