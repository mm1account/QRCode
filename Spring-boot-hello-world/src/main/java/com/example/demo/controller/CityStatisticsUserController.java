package com.example.demo.controller;


import com.example.demo.ResultAndExceptionDeal.BizException;
import com.example.demo.ResultAndExceptionDeal.R;
import com.example.demo.ResultAndExceptionDeal.ResponseResult;
import com.example.demo.VO.CityStatisticsVo;
import com.example.demo.service.CityStatisticsService;
import com.sun.deploy.security.BadCertificateDialog;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@ResponseResult
@RequestMapping("/admin")
@Transactional
public class CityStatisticsUserController {


    @Autowired
    private CityStatisticsService cityStatisticsService;

    @GetMapping("/getAllCityStatisticsUserNum")
    public List<CityStatisticsVo> getAllCityStatisticsUserNum() {

        List<CityStatisticsVo> allCityData = cityStatisticsService.getAllCityData();
        if(!Objects.isNull(allCityData)) {
            return allCityData;
        } else{
            throw new BizException("查询失败");
        }

    }


}
