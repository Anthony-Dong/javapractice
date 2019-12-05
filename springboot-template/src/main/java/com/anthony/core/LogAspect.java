package com.anthony.core;


import com.anthony.api.Log;
import com.anthony.api.SuccessfulResponse;
import com.anthony.exception.APIException;
import com.anthony.exception.ErrorCodeEnum;
import com.anthony.util.IpUtil;
import com.anthony.util.JsonUtils;
import com.anthony.util.Snowflake;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LogAspect {

    private static Snowflake snowflake = Snowflake.of();

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 可以将 加上 @ApiLog 注解的类 环绕通知
    @Pointcut("@annotation(com.anthony.api.ApiLog)")
    public void logPointCut() {
    }


    //环绕通知
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        boolean hasException = false;
        Long start = System.currentTimeMillis();
        Object result = null;
        HttpServletRequest request = null;
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            request = attributes.getRequest();
            result = point.proceed();
            return result;

        } catch (Exception e) {

            // 这里做了 异常处理  , 但是没有灵性了 , 可以根据需求改 .

            hasException = true;

            //  可以根据其他情况去做
            throw new APIException(ErrorCodeEnum.BAD_REQUEST);

        } finally {
            // 一般是 finally 做日志 , 我错了 , 大佬们看需求
            // 做日志处理
            String ipAddress = IpUtil.getIpAddress(request);

            Object result1 = null;
            if (result instanceof SuccessfulResponse) {
                result1 = ((SuccessfulResponse) result).getResult();
            }

            Log log = Log.builder()
                    .ip(ipAddress)
                    .mapping(request.getServletPath())
                    .method(request.getMethod())
                    .result(result1)
                    .requestBody(point.getArgs())
                    .url(request.getRequestURL().toString())
                    .uid(snowflake.nextId())
                    .runTime(System.currentTimeMillis() - start)
                    .hasException(hasException)
                    .build();

            // JSON 序列化 一下
            logger.info(JsonUtils.serialize(log));

            // 释放对象 有助于 垃圾回收
            result = null;
            request = null;
            start = null;
            result1 = null;
            log = null;
        }
    }
}

