package org.exercise2;


import org.exercise1.Student;

import java.util.List;

public class Lab2Main {

    public static void main(String[] args) {
        StudentCrudService service = new StudentCrudService();

        try {
            // 1. Create students
            Student s1 = service.createStudent("John", "Doe", "john.doe@example.com");
            Student s2 = service.createStudent("Jane", "Smith", "jane.smith@example.com");

            System.out.println("Created: " + s1);
            System.out.println("Created: " + s2);

            // 2. Read all
            System.out.println("=== All Students ===");
            List<Student> students = service.findAllStudents();
            students.forEach(System.out::println);

            // 3. Update
            service.updateStudentEmail(s1.getId(), "john.new@example.com");
            System.out.println("After update: " + service.findStudentById(s1.getId()));

            // 4. Delete
            service.deleteStudent(s2.getId());
            System.out.println("After delete:");
            service.findAllStudents().forEach(System.out::println);

        } finally {
            service.shutdown();
        }
    }
}