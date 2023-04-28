package com.example.spring_crud.service;

import com.example.spring_crud.exception.ResourceNotFoundException;
import com.example.spring_crud.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id) throws ResourceNotFoundException;
    Employee updateEmployee(Employee employee,int id) throws ResourceNotFoundException;

    void deleteEmployeeId( int id) throws ResourceNotFoundException;
}
