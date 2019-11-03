package com.javase.class_package.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 * @date:2019/9/15 13:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface TypeAnnotation {

    String value() default "";
}
