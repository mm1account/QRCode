package com.example.demo.mapper;

import com.example.demo.PO.AdminUserLoginPo;
import com.example.demo.VO.AdminUserLoginVo;
import com.example.demo.model.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminUserMapper {

    @Select({"select userName,pwd,path from adminUser where userName  = #{userName}"})
    public AdminUserLoginVo getAdminUserByUserName(String userName);

}
