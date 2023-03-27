package com.example.demo.PO;

public class CityStatisticsUserPo {

    private String city;
    private int num;

    public CityStatisticsUserPo() {
    }

    public CityStatisticsUserPo(String city, int num) {
        this.city = city;
        this.num = num;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
