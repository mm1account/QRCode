package com.example.demo.service.impl;

import com.example.demo.VO.CityStatisticsVo;
import com.example.demo.mapper.CityStatisticsMapper;
import com.example.demo.service.CityStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityStatisticsServiceImpl implements CityStatisticsService {


    @Autowired
    private CityStatisticsMapper cityStatisticsMapper;

    @Override
    public List<CityStatisticsVo> getAllCityData() {
        return cityStatisticsMapper.getAllCityData();
    }

    @Override
    public int updateCityDataByName(String id) {
        return cityStatisticsMapper.updateCityDataByName(id);
    }

    @Override
    public int updateCityDataById(List<Integer> list) {
        for(int i = 1;i < list.size();i++) {
            cityStatisticsMapper.updateCityDataById(Integer.toString(i),list.get(i));
        }
        return 1;
    }
}
