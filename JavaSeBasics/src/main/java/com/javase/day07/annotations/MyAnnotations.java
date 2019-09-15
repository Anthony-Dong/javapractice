package com.javase.day07.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:MyAnnotation
 * Package:com.javase.day07.annotations
 * Description:
 *
 * @date:2019/7/13 0:55
 * @author: 574986060@qq.com
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MyAnnotations {

    MyAnnotation[] value();
}
