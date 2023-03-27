package com.example.demo.controller;

import com.example.demo.JWT.JWTUtils;
import com.example.demo.PO.AdminUserLoginPo;
import com.example.demo.ResultAndExceptionDeal.BizException;
import com.example.demo.ResultAndExceptionDeal.ResponseResult;
import com.example.demo.VO.AdminUserLoginVo;
import com.example.demo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@ResponseResult
@RequestMapping("/admin")
@Transactional
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @PostMapping(value = "/login")
    public Map<String,String> adminUserLogin(@RequestBody AdminUserLoginPo adminUserLoginPo) {

        System.out.println(adminUserLoginPo.getUserName());
        AdminUserLoginVo adminUserByUserName = adminUserService.getAdminUserByUserName(adminUserLoginPo.getUserName());

        if(!Objects.isNull(adminUserByUserName.getPwd()) && adminUserLoginPo.getPwd().equals(adminUserByUserName.getPwd())) {
            HashMap<String, String> hashMap = new HashMap<>();
            HashMap<String, String> res = new HashMap<>();
            hashMap.put("userName",adminUserLoginPo.getUserName());
            String token = JWTUtils.getToken(hashMap);
            res.put("token",token);
            res.put("userName",adminUserByUserName.getUserName());
            res.put("path",adminUserByUserName.getPath());
            return res;
        } else {
            throw new BizException("用户名或密码错误");
        }

    }

}
