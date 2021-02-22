package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface InterfaceOfRepository {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    int totalCost();
}