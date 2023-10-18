package com.kavya.kavya_springboot_session.repository;

import com.kavya.kavya_springboot_session.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    @Query(value = "select * from employee_table where salary=?1",nativeQuery = true)
    Employee findBySalary(double salary);

    @Query(value = "select * from employee_table order by salary",nativeQuery = true)
    List<Employee> findSortedEmployeeBySalary();
}
