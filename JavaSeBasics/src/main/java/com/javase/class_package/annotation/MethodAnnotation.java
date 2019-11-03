package com.javase.class_package.annotation;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1. RetentionPolicy.SOURCE
 *      SOURCE: 注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 *      CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期
 *      RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 *      这3个生命周期分别对应于：Java源文件(.java文件) ---> .class文件 ---> 内存中的字节码。
 *
 *      明确生命周期长度 SOURCE < CLASS < RUNTIME ，所以前者能作用的地方后者一定也能作用
 *      比如 @Override 和 @SuppressWarnings，则可选用 SOURCE 注解。
 *      如果要在编译时进行一些预处理操作，比如生成一些辅助代码（如 ButterKnife），就用 CLASS注解
 *      如果需要在运行时去动态获取注解信息，那只能用 RUNTIME 注解
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {


    String value() default "";
}
