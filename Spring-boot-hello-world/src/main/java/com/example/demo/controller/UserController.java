package com.example.demo.controller;

import com.example.demo.JWT.JWTUtils;
import com.example.demo.PO.HealthCodePo;
import com.example.demo.ResultAndExceptionDeal.*;
import com.example.demo.PO.UserLoginPo;
import com.example.demo.model.User;
import com.example.demo.service.CityStatisticsService;
import com.example.demo.service.UserService;
import com.example.demo.utils.CityUtils;
import com.example.demo.utils.IfFunction;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@RestController
@ResponseResult
@RequestMapping("/api")
@Transactional
public class UserController {


    static ArrayList<Integer> idCardList =  new ArrayList(15);
    private Lock lock=new ReentrantLock();
    @Autowired
    private UserService userService;

    @Autowired
    private CityStatisticsService cityStatisticsService;
    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/addUser")

    public int UserAdd(@RequestBody User user) {
        int result = userService.userAdd(user);

        if (result == 0) {
            throw new BizException("插入失败");
        } else {
            System.out.println(user.getIdCard()+"----------");
            int updateRes = userService.addHealthCodeStatusByIdCard(new HealthCodePo(user.getIdCard(),0));
            return result;
        }
    }

    /**
     * 根据idCard来领取健康码
     * @param idCard 身份证号
     * @return  updateHealthCode
     */
    @GetMapping(value = "/updateHealthCode")
    public int updateHealthCodeByIdCard(@RequestParam(name = "idCard") String idCard) {

        System.out.println(idCard);
        int i = userService.updateHealthCodeStatusByIdCard(new HealthCodePo(idCard, 3));
        idCard = idCard.substring(3,4);
        if (i == 1) {
//            UserController.idCardList.add(idCard);
            try {
                lock.lock();
//                UserController.idCardList.add(Integer.parseInt(idCard.substring(3,4)));
                UserController.idCardList.add(Integer.parseInt(idCard.substring(0,1)));
                if(UserController.idCardList.size() == 1000) {
//                    UserController.idCardList.stream()

                    UserController.idCardList.stream().forEach(s -> {
                        CityUtils.getIfFunction(idCardList);
                    });
                    cityStatisticsService.updateCityDataById(UserController.idCardList);
                    UserController.idCardList.clear();
                }
            } finally {
                lock.unlock();
            }

            return i;
        } else {
            throw new BizException("更新失败");
        }
    }

    /**
     * 用户登录
     * @param
     * @return
     */
    @PostMapping(value = "/login")
    public Map<String, String> UserLogin(@RequestBody UserLoginPo userLoginPo) {
        R r = new R();
        //通过身份证查找姓名
        UserLoginPo user = userService.getUserByIdCard(userLoginPo.getIdCard());
        HealthCodePo healthCodeByIdCard = userService.getHealthCodeByIdCard(userLoginPo.getIdCard());
        //身份证号错误 或者用户姓名输入错误
        if (Objects.isNull(user) || user.getUserName().length() == 0 || !userLoginPo.getUserName().equals(user.getUserName())) {
            throw new BizException("用户名或者密码错误");
        }
        //如果身份证号和姓名输入正确，那么就生成token
        user.setStatus(healthCodeByIdCard.getStatus());
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("idCard", user.getIdCard());
        String token = JWTUtils.getToken(hashMap);
        HashMap<String, String> res = new HashMap<>();
        res.put("token", token);
        res.put("status", Integer.toString(user.getStatus()));

        return res;
//        System.out.println(R.success().getData());
    }



}