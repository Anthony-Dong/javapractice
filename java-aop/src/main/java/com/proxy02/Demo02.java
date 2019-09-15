package com.proxy02;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * ClassName:Demo02
 * Package:com.proxy02
 * Description:TODO
 *
 * @date:2019/9/6 16:11
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo02 {


//    public static void test(String name) {
//
//        System.out.println(name);
//    }
//
//    public static void test() {
//        String name = "1111";
//        test(name);
//    }


    /**
     *
     *           Class<AnnotationTest> clazz = AnnotationTest.class;
     *         Method method = clazz.getMethod("test");
     *         clazz.getEnclosingConstructor();
     *         MyMethod annotation = method.getAnnotation(MyMethod.class);
     *         System.out.println(annotation.value());
     */

    @Test
    public void test02() throws Exception{

        Class<Demo02> clazz = Demo02.class;

        Method method = clazz.getMethod("test", String.class);




        MyMethod annotation = method.getAnnotation(MyMethod.class);

        String value = annotation.value();
        System.out.println(value);

        Parameter[] parameters = method.getParameters();

        for (Parameter parameter : parameters) {
            MyTarget annotation1 = parameter.getAnnotation(MyTarget.class);
            String value1 = annotation1.value();
            System.out.println(annotation1.value());
        }

    }

    @MyMethod("1111111111111")
    public void test(@MyTarget("22222222") String name) {
        System.out.println(name);
    }


}
