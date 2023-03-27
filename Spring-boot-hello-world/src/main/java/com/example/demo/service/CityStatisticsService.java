package com.example.demo.service;

import com.example.demo.VO.CityStatisticsVo;
import com.example.demo.mapper.CityStatisticsMapper;
import io.swagger.models.auth.In;

import java.util.List;

public interface CityStatisticsService {

    List<CityStatisticsVo> getAllCityData();
    int updateCityDataByName(String id);

    int updateCityDataById(List<Integer> list);

}
