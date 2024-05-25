package net.employeemanagement.springboot.service;

import java.util.List;

import net.employeemanagement.springboot.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee , Long id);
    void deleteEmployee(Long id);
}
