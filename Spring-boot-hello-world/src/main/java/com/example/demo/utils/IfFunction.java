package com.example.demo.utils;

import java.util.Map;

public class IfFunction<K> {

    private Map<K, Function> map;

    public IfFunction(Map<K, Function> map) {
        this.map = map;
    }

    /**
     * 添加条件
     * @param key  需要验证的条件
     * @param function 要执行的方法
     * @return
     */
    public IfFunction<K> add(K key, Function function) {
        this.map.put(key, function);
        return this;
    }

    /**
     * 确定key是否存在，如果存在，则执行对应的方法
     * @param key
     */
    public void doIf(K key) {
        if(this.map.containsKey(key)) {
            map.get(key).invoke();
        }
    }

    /**
     * 确定key是否存在，如果存在，则执行对应的方法
     * 否则执行默认方法
     * @param key 需要验证的条件（key）
     * @param defaultFunction 要执行的方法
     */
    public void doIfWithDefault(K key, Function defaultFunction) {
        if(this.map.containsKey(key)) {
            map.get(key).invoke();
        } else {
            defaultFunction.invoke();
        }
    }





}
