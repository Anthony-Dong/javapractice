package com.javase.day07.annotations;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * ClassName:Annotation
 * Package:com.javase.day07.annotations
 * Description:
 *
 * @date:2019/7/13 0:57
 * @author: 574986060@qq.com
 */
@MyAnnotation("我是类上的")
public class AnnotationTest {

    @Test
    public void test02() throws Exception {
//        Object o = Class.forName("com.javase.day07.annotations.AnnotationTest").newInstance();

        Class<AnnotationTest> clazz = AnnotationTest.class;
        Method method = clazz.getMethod("test");
        clazz.getEnclosingConstructor();
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
        MyAnnotation[] annotationsByType = method.getAnnotationsByType(MyAnnotation.class);

        for (MyAnnotation m : annotationsByType) {
            System.out.println(m.value());
        }
    }

    @MyAnnotation("方法1")
    @MyAnnotation("方法1")
    public void test(){

    }

}
