package com.example.demo.VO;

public class CityStatisticsVo {


    private String city;
    private int num;

    public CityStatisticsVo() {
    }

    public CityStatisticsVo(String city, int num) {
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
