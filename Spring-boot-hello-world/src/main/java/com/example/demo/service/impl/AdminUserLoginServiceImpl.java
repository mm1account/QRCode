package com.example.demo.service.impl;

import com.example.demo.VO.AdminUserLoginVo;
import com.example.demo.mapper.AdminUserMapper;
import com.example.demo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserLoginServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUserLoginVo getAdminUserByUserName(String userName) {
        return adminUserMapper.getAdminUserByUserName(userName);
    }
}
