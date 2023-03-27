package com.example.demo.model;

public class AdminUser {

    private String userName;
    private String pwd;
    private String path;

    public AdminUser() {
    }

    public AdminUser(String userName, String pwd, String path) {
        this.userName = userName;
        this.pwd = pwd;
        this.path = path;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
