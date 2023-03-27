package com.example.demo.model;

/**
 * 用户实体的类
 */
public class User {

    private String userName;

    private String idCard;

    private String tel;

    public User() {
    }

    public User(String userName, String idCard, String tel) {
        this.userName = userName;
        this.idCard = idCard;
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
