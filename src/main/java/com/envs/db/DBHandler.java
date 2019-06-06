package com.envs.db;

import com.envs.middle.Environment;
import com.envs.middle.User;

import java.util.List;

public class DBHandler {
    private String url;
    private DBConnector dbConnector;

    private Environment environment;
    private List<User> users;

    public DBHandler(String url) {
        this.url = url;
        dbConnector = new DBConnector(url);
    }

    public Environment getEnvironment() {
        dbConnector.sendMessage("get Users");
        dbConnector.getMessage();

        return environment;
    }

    public List<User> getUsers() {
        return users;
    }
}
