package com.example.demo.mapper;

import com.example.demo.PO.HealthCodePo;
import com.example.demo.PO.UserLoginPo;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {


    @Insert({"insert into user (userName,idCard,tel) VALUES (#{userName},#{idCard},#{tel})"})
    int userAdd(User user) ;

    @Select({"select idCard,userName from user where idCard = #{idCard}"})
    UserLoginPo getUserByIdCard(String idCard);

    @Select({"select status from healthQRCodeUsed where idCard = #{idCard}"})
    HealthCodePo getHealthCodeByIdCard(String idCard);



    @Update("update user set isShowed = 1 where idCard = #{idCard}")
    int updateHealthCodeByIdCard(String idCard);

    @Insert({"insert into healthQRCodeUsed (idCard,status) values (#{idCard},#{status})"})
    int addHealthCodeStatusByIdCard(HealthCodePo healthCodePo);

    //update healthQRCodeUsed set status = #{status} where idCard = #{idCard}}
    @Update({"update healthQRCodeUsed set status = #{status} where idCard = #{idCard}"})
    int updateHealthCodeStatusByIdCard(HealthCodePo healthCodePo);




}
