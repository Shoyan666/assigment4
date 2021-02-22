package com.company;

import com.company.controllers.EmployeeController;
import com.company.repositories.interfaces.InterfaceOfRepository;

import java.util.Scanner;

public class Myapplication {
    private final EmployeeController controller;
    private final Scanner scanner;
    public Myapplication(InterfaceOfRepository employeeRepository) {
        controller = new EmployeeController(employeeRepository);
        scanner = new Scanner(System.in);
    }
    public void start() { //
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");//greeting user
            System.out.println("Select option:"); // asks user to select which option he or she wants to do
            System.out.println("1. Get all employees"); // first option to get info about all employees in company
            System.out.println("2. Get employee by individual number"); // second option to get info about particular employee in compaany
            System.out.println("3. Create employee");
            System.out.println("4. Calculate total amount of salary for all employees");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter the option 0-4: ");
                int option = scanner.nextInt(); // variable option reads the program to complete the option which chosen by user
                if (option == 1) { //if chosen option 1 then get all employees from database etc until
                    getAllEmployeesMenu();
                }
                else if (option == 2) {
                    getEmployeeByIdMenu();
                }
                else if (option == 3) {
                    createEmployeeMenu();
                }
                else if (option == 4) {
                    totalCostMenu();
                }
                else { // until user did not choose any given option
                    break; // program breaks or stops
                }
            }
            catch (Exception exceptioninprogram) { // catch expectation in inputted data
                System.out.println(exceptioninprogram.getMessage());
                scanner.next(); // reads next
            }
            System.out.println("******");
        }
    }
    public void getAllEmployeesMenu() {
        String response = controller.getAllEmployees();
        System.out.println(response);
    }
    public void getEmployeeByIdMenu() {
        System.out.print("Enter the individual number or id : ");
        int id = scanner.nextInt();
        String response = controller.getEmployee(id);
        System.out.println(response);
    }

    public void createEmployeeMenu() { // program calls menu which gives an opportunity to run a program and cooperate with the user
        System.out.print("Enter the First name: "); //asks to enter the first name of worker
        String name = scanner.next();
        System.out.print("Enter the Second name: ");//asks to enter the second name of worker
        String surname = scanner.next();
        System.out.print("Enter the occupation: ");//asks to enter the occupation
        String post = scanner.next();
        System.out.print("Enter the salary: "); ////asks to enter the salary
        int salary = scanner.nextInt();

        String answer = controller.createEmployee(name, surname, salary, post); //by using controller it displays final answer
        System.out.println(answer);
    }
    public void totalCostMenu() { // void class to calculate the total salary for all employees
        int answer = controller.totalCost();
        System.out.println("Total salary of all employees is: " + answer);
    }
}
