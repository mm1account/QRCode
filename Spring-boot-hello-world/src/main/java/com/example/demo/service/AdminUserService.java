package com.example.demo.service;

import com.example.demo.VO.AdminUserLoginVo;

public interface AdminUserService {

    public AdminUserLoginVo getAdminUserByUserName(String userName);

}
