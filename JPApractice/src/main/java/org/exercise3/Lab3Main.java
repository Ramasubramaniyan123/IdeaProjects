package org.exercise3;


import org.exercise1.Student;
import org.exercise2.StudentCrudService;
import java.util.List;

public class Lab3Main {

    public static void main(String[] args) {
        StudentCrudService service = new StudentCrudService();
        StudentQueryService queryService=new StudentQueryService();
        try {
            // Ensure we have some data
            if (service.findAllStudents().isEmpty()) {
                service.createStudent("Alice", "Singh", "alice.singh@example.com");
                service.createStudent("Bob", "Singh", "bob.singh@example.com");
                service.createStudent("Charlie", "Brown", "charlie.brown@example.com");
            }

            System.out.println("Total students: " + queryService.countStudents());

            System.out.println("=== Students with lastName = 'Singh' ===");
            List<Student> singhList = queryService.findByLastName("Singh");
            singhList.forEach(System.out::println);

        } finally {
            service.shutdown();
        }
    }
}