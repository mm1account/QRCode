package com.example.demo.utils;

//用来判断地区
public enum CityEnum {
    NN(1,"南宁"),
    LZ(2,"柳州"),
    GL(3,"桂林"),
    WZ(4,"梧州"),
    BH(5,"北海"),
    FCG(6,"防城港"),
    QZ(7,"钦州"),
    GG(8,"贵港"),
    YL(9,"玉林"),
    BS(10,"百色"),
    HZ(11,"贺州"),
    HC(12,"河池"),
    LB(13,"来宾"),
    CZ(14,"崇左")
    ;


    private Integer code;
    private String city;

    CityEnum() {
    }

    CityEnum(Integer code, String city) {
        this.code = code;
        this.city = city;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
