package com.example.demo.mapper;

import com.example.demo.VO.CityStatisticsVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CityStatisticsMapper {

    @Results(id="groupWithUsers",  value = {
            @Result(property = "city", column = "city",jdbcType= JdbcType.VARCHAR),
            @Result(property = "num", column = "num",jdbcType= JdbcType.INTEGER)})
    @Select({"select city,num from statisticsUser"})
    List<CityStatisticsVo> getAllCityData();

    @Update("update statisticsUser set num = num + 1 where id = #{id}")
    int updateCityDataByName(String id);

    @Update("update statisticsUser set num = num + #{num1} where id = #{id}")
    int updateCityDataById(String id,int num1);


}
