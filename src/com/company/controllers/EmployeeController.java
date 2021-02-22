package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.InterfaceOfRepository;

import java.util.List;

public class EmployeeController {
    private final InterfaceOfRepository repository;
    public EmployeeController(InterfaceOfRepository repository) {
        this.repository = repository;
    }
    public String createEmployee(String Firstname, String lastname, int salary, String post) {
        Employee employee = new Employee(Firstname, lastname, salary, post);
        boolean created = repository.createEmployee(employee);

        return (created ? "You have successfully added employee!" : "Oops there is a mistake and employee creation was failed!");
    }
    public String getEmployee(int id) {
        Employee employee = repository.getEmployee(id);

        return (employee == null ? "We can not find any employee" : employee.toString());
    }
    public String getAllEmployees() {
        List<Employee> employees = repository.getAllEmployees();
        return employees.toString();
    }
    public int totalCost() {
        int totalSalary = repository.totalCost();
        return totalSalary;
    }
}