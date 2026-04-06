package Practice;

import java.util.Scanner;

public class PracticeDemo {

    static void main(String[] args) {

        UtilityMethods util = new UtilityMethods();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Insert Employee
                    2. Update Salary
                    3. Delete Employee
                    4. Print Employees
                    5. Get First Name
                    6. Exit
                    """);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("First Name: ");
                    String fname = sc.next();

                    System.out.print("Last Name: ");
                    String lname = sc.next();

                    System.out.print("Email: ");
                    String email = sc.next();

                    System.out.print("Department: ");
                    String dept = sc.next();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    util.insert(fname, lname, email, dept, salary);
                }

                case 2 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();

                    System.out.print("New Salary: ");
                    double salary = sc.nextDouble();

                    util.updateSalary(id, salary);
                }

                case 3 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();

                    util.delete(id);
                }

                case 4 -> util.printAll();

                case 5 -> {
                    System.out.print("Employee ID: ");
                    int id = sc.nextInt();
                    util.getFirstName(id);
                }
                case 6 -> {
                    System.out.println("Exiting application.");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
