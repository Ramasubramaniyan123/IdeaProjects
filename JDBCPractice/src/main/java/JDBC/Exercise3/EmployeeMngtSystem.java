package JDBC.Exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMngtSystem {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee Salary");
            System.out.println("3. Delete Employee");
            System.out.println("4. List All Employees");
            System.out.println("5. Find Employee By ID");
            System.out.println("6. Remove Duplicate Employees");
            System.out.println("7. Order Employees By Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Enter employee name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(name, salary);
                        break;
                    case 2:
                        System.out.print("Enter employee ID: ");
                        int empIdUpdate = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSalary = sc.nextDouble();
                        dao.updateSalary(empIdUpdate, newSalary);
                        break;

                    case 3:
                        System.out.print("Enter employee ID to delete: ");
                        int empIdDelete = sc.nextInt();
                        dao.deleteEmployee(empIdDelete);
                        break;
                    case 4:
                        dao.listEmployees();
                        break;
                    case 5:
                        System.out.print("Enter employee ID to search: ");
                        int empIdFind = sc.nextInt();
                        dao.findById(empIdFind);
                        break;
                    case 6:
                        dao.removeDuplicates();
                        break;
                    case 7:
                        dao.orderByName();
                        break;
                    case 8:
                        System.out.println("Exiting application. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select between 1–8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numeric values only.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
