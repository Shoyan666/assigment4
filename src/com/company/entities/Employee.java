package com.company.entities;

public class Employee {
    private String firstname, lastname, post;
    private int id, salary;

    public Employee(int Employee_id, String fname, String lname, String post, int salary) {
        setFirstname(fname);
        setLastname(lname);
        setSalary(salary);
        setPost(post);
    }

    public Employee(String name, String lastname, int salary, String post) {
        setFirstname(name);
        setLastname(lastname);
        setSalary(salary);
        setPost(post);

    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id= " + id +
                ", First name='" + firstname + '\'' +
                ", Last name='" + lastname + '\'' +
                ", salary=" + salary +
                ", post=" + post +
                '}';
    }
}