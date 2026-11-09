
package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JPAUtil
{
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    static
    {
        String dbPassword = System.getenv("DB_PASSWORD");

        if (dbPassword == null || dbPassword.isBlank()) {
            throw new IllegalStateException("DB_PASSWORD environment variable is not set");
        }

        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.jdbc.password", dbPassword);

        factory = Persistence.createEntityManagerFactory("JPA-PU", properties);
    }

    public static EntityManager getEntityManager()
    {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
}
