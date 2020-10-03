package org.revinton.payapp.persistence.repositories;

import org.revinton.payapp.core.utility.Environment;
import org.revinton.payapp.persistence.JdbcVariableGetter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractRepository {

    private EntityManagerFactory managerFactory;

    public AbstractRepository() {
        JdbcVariableGetter jdbcVariableGetter = new JdbcVariableGetter();
        Map<String, String> dataSourceProperties = jdbcVariableGetter.getDataSourceProperties();
        String dbName = jdbcVariableGetter.getDbName();
        managerFactory = Persistence.createEntityManagerFactory(dbName, dataSourceProperties);
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
}
