package com.tinder_application.models;

public class Credentials {
    private int credId;
    private String email;
    private String password;

    public Credentials(int credId, String email, String password) {
        this.credId = credId;
        this.email = email;
        this.password = password;
    }

    public Credentials() {
    }

    public int getCredId() {
        return credId;
    }

    public void setCredId(int credId) {
        this.credId = credId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
