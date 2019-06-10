package com.envs.middle;

public class User {
    private String userName, password;
    private int balanceInCents;
    private boolean isAvailable;
    private String lastTimeVerified;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalanceInCents() {
        return balanceInCents;
    }

    public void setBalanceInCents(int balanceInCents) {
        this.balanceInCents = balanceInCents;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getLastTimeVerified() {
        return lastTimeVerified;
    }

    public void setLastTimeVerified(String lastTimeVerified) {
        this.lastTimeVerified = lastTimeVerified;
    }
}
