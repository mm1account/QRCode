package com.example.demo.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class CityUtils {

    static IfFunction<String> ifFunction = new IfFunction<>(new HashMap<>(14));

    public static IfFunction<String> getIfFunction(ArrayList<Integer> as) {
        CityUtils.ifFunction.add("1", ()-> as.add(as.get(1)+1))
               .add("2",()-> as.add(as.get(2)+1))
               .add("3", () -> as.add(as.get(3)+1))
               .add("4",()-> as.add(as.get(4)+1))
               .add("5", () -> as.add(as.get(5)+1))
                .add("6",()-> as.add(as.get(6)+1))
                .add("7", () -> as.add(as.get(7)+1))
                .add("8",()-> as.add(as.get(8)+1))
                .add("9", () -> as.add(as.get(9)+1))
               .add("10", () -> as.add(as.get(10)+1))
               .add("11",()-> as.add(as.get(11)+1))
               .add("12", () -> as.add(as.get(12)+1))
               .add("13",()-> as.add(as.get(13)+1))
               .add("14", () -> as.add(as.get(14)+1));

       return ifFunction;
    }

}
