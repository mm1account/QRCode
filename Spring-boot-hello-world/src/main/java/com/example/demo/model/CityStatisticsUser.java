package com.example.demo.model;

public class CityStatisticsUser {

    private int id;
    private String city;
    int num;

    public CityStatisticsUser() {
    }

    public CityStatisticsUser(int id, String city, int num) {
        this.id = id;
        this.city = city;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
