package com.javase.class_package;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @date:2019/9/15 13:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {

    String value() default "";
}
