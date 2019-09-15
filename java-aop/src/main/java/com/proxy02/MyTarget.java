package com.proxy02;


import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTarget {
    @AliasFor("name")
    String value() default "";


    @AliasFor("value")
    String name() default "";
}
