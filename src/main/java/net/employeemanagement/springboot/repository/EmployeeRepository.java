package net.employeemanagement.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.employeemanagement.springboot.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee , Long>{
    
}