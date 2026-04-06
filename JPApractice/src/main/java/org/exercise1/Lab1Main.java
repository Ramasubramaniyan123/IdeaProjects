package org.exercise1;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Lab1Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("labPU");
            em = emf.createEntityManager();
            System.out.println("EntityManager created successfully!");

        } finally {
            if (em != null) {
                em.close();
                System.out.println("EntityManager closed.");
            }
            if (emf != null) {
                emf.close();
                System.out.println("EntityManagerFactory closed.");
            }
        }
    }
}