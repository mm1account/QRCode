package com.example.demo.service.impl;

import com.example.demo.PO.HealthCodePo;
import com.example.demo.PO.UserLoginPo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int userAdd(User user)  {
        return userMapper.userAdd(user);
    }

    @Override
    public UserLoginPo getUserByIdCard(String idCard) {
        return userMapper.getUserByIdCard(idCard);
    }

    @Override
    public int updateHealthCodeByIdCard(String idCard) {

        return userMapper.updateHealthCodeByIdCard(idCard);
    }

    @Override
    public int updateHealthCodeStatusByIdCard(HealthCodePo healthCodePo) {
        return userMapper.updateHealthCodeStatusByIdCard(healthCodePo);
    }

    @Override
    public int addHealthCodeStatusByIdCard(HealthCodePo healthCodePo) {
        return userMapper.addHealthCodeStatusByIdCard(healthCodePo);
    }

    @Override
    public HealthCodePo getHealthCodeByIdCard(String idCard) {
        return userMapper.getHealthCodeByIdCard(idCard);
    }

}
