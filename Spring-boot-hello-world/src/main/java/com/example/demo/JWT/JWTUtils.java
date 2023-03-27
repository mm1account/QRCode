package com.example.demo.JWT;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Description: JWT工具类
 */
public class JWTUtils {
    //秘钥
    private static final String SIGNATURE = "aef7aaf174fa0143ce765a7efd869313";
    //过期时间为1天
    public static  final Integer EXPIRATION_TIME= 1* 24 * 60 * 60;



    /**
     * 生成token
     * @param payload token需要携带的信息
     * @return token字符串
     */
    public static String getToken(Map<String,String> payload){
        // 指定token过期时间为1天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, EXPIRATION_TIME);
        JWTCreator.Builder builder = JWT.create();
        // 构建payload
        payload.forEach((k,v) -> builder.withClaim(k,v));
        // 指定过期时间和签名算法
        return  builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SIGNATURE));
    }




    /**
     * 验证token
     * @param token
     */
    public static void verify(String token){
        JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

    /**
     * 获取token中payload
     * @param token
     * @return
     */
    public static DecodedJWT getPayload(String token){
        return JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
    }

}

