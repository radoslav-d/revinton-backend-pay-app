package org.revinton.payapp.core.utility;

import com.google.gson.Gson;

public class Environment {

    private Gson gson;

    public Environment() {
        this.gson = new Gson();
    }

    public String getVariable(String name) {
        return System.getenv(name);
    }

    public <T> T getJsonVariable(String name, Class<T> classOfT) {
        String json = getVariable(name);
        return json == null ? null : gson.fromJson(json, classOfT);
    }
}
