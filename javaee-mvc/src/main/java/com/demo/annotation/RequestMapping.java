package com.demo.annotation;

import com.demo.config.RequestMethod;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @date:2019/9/15 15:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value() default "";


    RequestMethod method() default RequestMethod.GET;


}
