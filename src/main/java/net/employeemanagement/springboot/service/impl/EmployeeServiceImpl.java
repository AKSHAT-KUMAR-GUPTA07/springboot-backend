package net.employeemanagement.springboot.service.impl;

import java.util.List;
// import java.util.Optional; //long code way

import org.springframework.stereotype.Service;

import net.employeemanagement.springboot.exception.ResourceNotFoundException;
import net.employeemanagement.springboot.model.Employee;
import net.employeemanagement.springboot.repository.EmployeeRepository;
import net.employeemanagement.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // constructor bassed dependency / setter based dependecy
    // parameters are mandatory so constructor based dependency

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        // Optional<Employee> employee = employeeRepository.findById(id);
        // if(employee.isPresent()){
        // return employee.get();
        // }else{
        // throw new ResourceNotFoundException("Employee" , "Id" , id);
        // }
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        //first check wether the id exists or not
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save existing employee dont forget (you keep forgetting everytime)
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        
        //check wether the id is in db or not
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }

}
