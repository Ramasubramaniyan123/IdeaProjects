package org.exercise3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.exercise1.Student;

import java.util.List;

public class StudentQueryService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LabPU");

    public List<Student> findByLastName(String lastName) {

        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT s FROM Student s WHERE s.lastName = :ln", Student.class)
                    .setParameter("ln", lastName)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // Count students
    public long countStudents() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT COUNT(s) FROM Student s", Long.class)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
}