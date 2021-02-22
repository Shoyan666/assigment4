package com.company.repositories;
import com.company.data.interfaces.DataBase;
import com.company.entities.Employee;
import com.company.repositories.interfaces.InterfaceOfRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRep implements InterfaceOfRepository {
    private final DataBase db;
    public EmployeeRep(DataBase db) {
        this.db = db;
    }
    @Override
    public boolean createEmployee(Employee employee) {
        try {
            Connection con = db.getConnection();
            String sql = "INSERT INTO employee(FirstName, LastName, salary, post) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getFirstname());
            st.setString(2, employee.getLastname());
            st.setInt(3, employee.getSalary());
            st.setString(4, employee.getPost());
            boolean executed = st.execute();
            con.close();
            return executed;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        try {
            Connection con = db.getConnection();
            String sql = "Select * from Employee where Employee_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("Employee_id"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("post"),
                        rs.getInt("salary"));
                con.close();
                return employee;
            }
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        try {
            Connection con = db.getConnection();
            String sql = "select * from Employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("Employee_id"),
                        rs.getString("FirstName"),
                        rs.getString("SecondName"),
                        rs.getString("post"),
                        rs.getInt("salary"));

                employees.add(employee);
                con.close();
            }
            return employees;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int totalCost() {
        int totalSalary = 0;
        try {
            Connection con = db.getConnection();
            String sql = "select * salary from Employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                totalSalary = totalSalary + rs.getInt("salary");
                con.close();
            }
            return totalSalary;
        }
        catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return totalSalary;
    }
}