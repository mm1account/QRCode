package com.example.demo.PO;

public class UserLoginPo {

    private String idCard;
    private String userName;

    private int status;


    public UserLoginPo() {
    }

    public UserLoginPo(String idCard, String userName, int status) {
        this.idCard = idCard;
        this.userName = userName;
        this.status = status;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
