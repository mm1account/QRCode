package com.example.demo.controller;

import com.example.demo.ResultAndExceptionDeal.BizException;
import com.example.demo.ResultAndExceptionDeal.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseResult
public class TestController {

    @GetMapping("/test")
    public Map<String, Object> test() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("info", "成功");
        return data;
    }

    @GetMapping("/fail")
    public Integer error() {
        int res = 0; // 查询结果数
        if( res == 0 ) {
            throw new BizException("没有数据");
        }
        return res;
    }
}