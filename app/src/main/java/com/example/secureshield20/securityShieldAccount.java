package com.example.secureshield20;

public class securityShieldAccount {
    private String username;
    private String password;

    public securityShieldAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SecurityShieldAccount{" +
                "username='" + username + '\'' +
                ", password='" + password +'}';
    }
}