package com.anthony.interceptor;

import com.anthony.log.LogUtils;
import com.anthony.util.IpUtil;


import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.UUID;

/**
 * TODO
 *
 * @date:2019/9/20 20:55
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



        HandlerMethod method = (HandlerMethod) handler;


        LogUtils.printLog(System.currentTimeMillis(),
                UUID.randomUUID().toString(),
                request.getParameterMap(),
                binaryReader(request),
                request.getRequestURL().toString(),
                method.getBean().getClass().getName(),
                ((HandlerMethod) handler).getMethod().getName(),
                IpUtil.getIpAddress(request),
                null);
        request.getParameterMap();
        return true;
    }

    String binaryReader(HttpServletRequest request) {


        return "11111111111";
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("response.getStatus() = " + response.getStatus());


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
