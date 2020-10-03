package org.revinton.payapp.persistence.repositories;

import org.eclipse.persistence.config.EntityManagerProperties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractRepository {

    private static final String PERSISTENCE_UNIT = "MANAGEMENT";
    private EntityManagerFactory managerFactory;

    public AbstractRepository() {
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT, getDataSourceProperties());
    }

    protected final <R> R executeInTransaction(Function<EntityManager, R> function) {
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        R result = function.apply(manager);
        transaction.commit();
        manager.close();
        return result;
    }

    private Map<String, String> getDataSourceProperties() {
        Map<String, String> properties = new HashMap<>();
        // TODO get from environment
        properties.put(EntityManagerProperties.JDBC_DRIVER, "oracle.jdbc.OracleDriver");
        properties.put(EntityManagerProperties.JDBC_URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
        properties.put(EntityManagerProperties.JDBC_USER, "user-name");
        properties.put(EntityManagerProperties.JDBC_PASSWORD, "password");
        return properties;
    }
}
