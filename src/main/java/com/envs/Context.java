package com.envs;

import com.envs.middle.Environment;
import com.envs.middle.User;

import java.util.List;

public class Context {
    private Environment e;
    private List<User> users;

    private String gameCode;

    public Environment getEnvironment() {
        return e;
    }

    public void setEnvironment(Environment e) {
        this.e = e;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGameCode() {
        return "whk";
    }

}
