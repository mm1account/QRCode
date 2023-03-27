package com.example.demo.JWT;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.example.demo.ResultAndExceptionDeal.R;
import com.example.demo.ResultAndExceptionDeal.ResultCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: jwt拦截器
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中存放的令牌token
        String token = request.getHeader("Authorization");
        R result = new R();
//        CommonResult<CodeEnum> result=new CommonResult();
        try {
//            System.out.println(token.length());
            if(null != token){
//            if(StrUtil.isNotBlank(token)){
                //验证令牌
                JWTUtils.verify(token);
                return true;
            }else{
                result.setCode(ResultCode.JWT_INVALID.getCode());
                result.setMessage(ResultCode.JWT_INVALID.getMessage());
//                result.setCode(CodeEnum.JWT_INVALID.getCode());
//                result.setMessage(CodeEnum.JWT_INVALID.getMessage());
            }

        } catch (SignatureVerificationException e) {
            e.printStackTrace();

            result.setCode(ResultCode.JWT_INVALID.getCode());
            result.setMessage(ResultCode.JWT_INVALID.getMessage());
//            result.setCode(CodeEnum.JWT_INVALID.getCode());
//            result.setMessage(CodeEnum.JWT_INVALID.getMessage());
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            result.setCode(ResultCode.JWT_ALGORITHM_INCONSISTENCY.getCode());
            result.setMessage(ResultCode.JWT_ALGORITHM_INCONSISTENCY.getMessage());
//            result.setCode(CodeEnum.JWT_ALGORITHM_INCONSISTENCY.getCode());
//            result.setMessage(CodeEnum.JWT_ALGORITHM_INCONSISTENCY.getMessage());
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            result.setCode(ResultCode.JWT_OVERDUE.getCode());
            result.setMessage(ResultCode.JWT_OVERDUE.getMessage());
//            result.setCode(CodeEnum.JWT_OVERDUE.getCode());
//            result.setMessage(CodeEnum.JWT_OVERDUE.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(ResultCode.JWT_OVERDUE.getCode());
            result.setMessage(ResultCode.JWT_OVERDUE.getMessage());
//            result.setCode(CodeEnum.JWT_OVERDUE.getCode());
//            result.setMessage(CodeEnum.JWT_OVERDUE.getMessage());
        }


        //将map转为json，返回给前端
        String json = new ObjectMapper().writeValueAsString(result);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(json);
        return false;
    }
}

