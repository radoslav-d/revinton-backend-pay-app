package org.revinton.payapp.persistence.helpers;

import org.eclipse.persistence.config.EntityManagerProperties;
import org.revinton.payapp.core.utility.Environment;

import java.util.HashMap;
import java.util.Map;

public class JdbcVariableGetter {

    private static final String JDBC_POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final String VCAP_SERVICES = "VCAP_SERVICES";
    private static final String DB_NAME = "dbname";
    private static final String DB_URL = "uri";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    private Environment environment;

    public JdbcVariableGetter() {
        this.environment = new Environment();
    }

    public Map<String, Object> getDataSourceProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EntityManagerProperties.JDBC_DRIVER, JDBC_POSTGRESQL_DRIVER);
        properties.put(EntityManagerProperties.JDBC_URL, getUrl());
        properties.put(EntityManagerProperties.JDBC_USER, getUsername());
        properties.put(EntityManagerProperties.JDBC_PASSWORD, getPassword());
        return properties;
    }

    public String getDbName() {
        return getVcapServices(DB_NAME);
    }

    private String getUrl() {
        return getVcapServices(DB_URL);
    }

    private String getUsername() {
        return getVcapServices(DB_USERNAME);
    }

    private String getPassword() {
        return getVcapServices(DB_PASSWORD);
    }

    private String getVcapServices(String key) {
        return (String) environment.getJsonVariable(VCAP_SERVICES, VcapServices.class)
                                   .postgresql[0]
                                   .credentials
                                   .get(key);
    }

    private static class VcapServices {
        Postgresql[] postgresql;
    }

    private static class Postgresql {
        Map<String, Object> credentials;
    }
}
