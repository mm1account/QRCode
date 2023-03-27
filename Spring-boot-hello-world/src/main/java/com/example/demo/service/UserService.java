package com.example.demo.service;

import com.example.demo.PO.HealthCodePo;
import com.example.demo.PO.UserLoginPo;
import com.example.demo.model.User;

public interface UserService {

    int userAdd(User user) ;
;
    UserLoginPo getUserByIdCard(String idCard);

    int updateHealthCodeByIdCard(String idCard);

    int updateHealthCodeStatusByIdCard(HealthCodePo HealthCodePo);

    int addHealthCodeStatusByIdCard(HealthCodePo healthCodePo);

    HealthCodePo getHealthCodeByIdCard(String idCard);
}
