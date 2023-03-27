package com.example.demo.VO;

public class AdminUserLoginVo {

    private String userName;

    private String pwd;

    private String path;

    public AdminUserLoginVo() {
    }

    public AdminUserLoginVo(String userName, String pwd, String path) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "AdminUserLoginVo{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
