package com.envs.db;

public class DBConnector {
    private String url;

    public DBConnector(String url) {
        this.url = url;
        connect2DB(url);
    }

    public void sendMessage(String message) {

    }

    public String getMessage() {
        return null;
    }

    private void connect2DB(String url) {
        System.out.println(url);
    }
}
