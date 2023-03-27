package com.example.demo.PO;

public class AdminUserLoginPo {

    private String userName;
    private String pwd;

    public AdminUserLoginPo() {
    }

    public AdminUserLoginPo(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
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
}
