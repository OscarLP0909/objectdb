package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utilidad para gestionar la fábrica de EntityManager.
 */
public class ObjectDBUtil {

    private static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("data.odb");
    }

    /**
     * Retorna la instancia de EntityManagerFactory.
     *
     * @return la instancia de EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}