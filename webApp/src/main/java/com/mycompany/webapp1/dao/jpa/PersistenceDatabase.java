package com.mycompany.webapp1.dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersistenceDatabase {

    public static EntityManagerFactory emf = null;
    public static EntityManager em = null;
    public static EntityTransaction tx = null;

    public static EntityManager callingEntityManager() {
        try {
            emf = Persistence.createEntityManagerFactory("lms");
            em = emf.createEntityManager();
            return em;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
            em.clear();
        }
        return null;
    }
}
