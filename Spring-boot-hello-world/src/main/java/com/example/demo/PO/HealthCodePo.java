package com.example.demo.PO;

public class HealthCodePo {

    private String idCard;
    private int status;

    public HealthCodePo() {
    }

    public HealthCodePo(String idCard, int status) {
        this.idCard = idCard;
        this.status = status;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
