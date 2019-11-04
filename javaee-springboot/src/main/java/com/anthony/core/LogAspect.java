package com.anthony.core;

import com.anthony.api.Log;
import com.anthony.exception.APIException;
import com.anthony.exception.ErrorCodeEnum;
import com.anthony.util.IpUtil;
import com.anthony.util.JsonUtils;
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
import java.util.UUID;

@Aspect
@Component
public class LogAspect {


    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    // 可以将 加上 @ApiLog 注解的类 环绕通知
    @Pointcut("@annotation(com.anthony.api.ApiLog)")
    public void logPointCut() {
    }


    //环绕通知
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        HttpServletRequest request = null;
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            request = attributes.getRequest();
            result = point.proceed();

/*            // 记录下请求内容
            logger.info("doBefore : 请求地址 : " + request.getRequestURL().toString());
            logger.info("doBefore :  HTTP METHOD : " + request.getMethod());
            logger.info("doBefore :  CLASS_METHOD : " + point.getSignature().getDeclaringTypeName() + "."
                    + point.getSignature().getName());
            // 执行方法

            logger.info("doBefore  :  方法参数 : " + Arrays.toString(point.getArgs()));

            logger.info("doBefore :  方法返回值 : " + result);

            logger.info("doAfterReturning");*/
            return result;

        } catch (Exception e) {

            // 这里做了 异常处理  , 但是没有灵性了 , 可以根据需求改 .

            //  可以根据其他情况去做

            throw new APIException(ErrorCodeEnum.BAD_REQUEST);

        } finally {
            // 一般是 finally 做日志 , 我错了 , 大佬们看需求
            // 做日志处理
            String ipAddress = IpUtil.getIpAddress(request);

            Log log = Log.builder().ip(ipAddress).mapping(ipAddress).method(request.getMethod())
                    .parameterMap(null)
                    .result(result)
                    .requestBody(point.getArgs())
                    .url(request.getRequestURL().toString())
                    .uid(UUID.randomUUID().toString())
                    .build();

            // JSON 序列化 一下
            logger.info(JsonUtils.serialize(log));

            // 释放对象 有助于 垃圾回收
            result = null;
            request = null;

        }
    }
}