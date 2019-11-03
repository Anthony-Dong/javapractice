package com.javase.class_package.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 测试 class
 *
 * @date:2019/9/15 13:06
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoClass {


    public static void main(String[] args) throws Exception {

        /**
         * 通过反射生成对象的三种方式
         *  反射的作用：
         *  1）可以通过反射机制发现对象的类型，找到类中包含的方法、属性和构造器
         *  2）可以通过反射创建对象并访问任意对象方法和属性
         *
         */


        //1.  Class.forName();

//        Class<Clazz> clazzClass = Clazz.class;


        Class<?> clazz = Class.forName("com.javase.class_package.annotation.Clazz");
        System.out.println("clazz.getName() = " + clazz.getName());



        Clazz clazz1 = (Clazz) clazz.newInstance();
        Clazz clazz2 = (Clazz) clazz.getConstructor(String.class).newInstance("成员变量");

        System.out.println("clazz2.getName() = " + clazz2.getName());

        clazz2.test("class2");

        clazz1.test("clazz1");


        TypeAnnotation annotation = clazz.getDeclaredAnnotation(TypeAnnotation.class);
        System.out.println("annotation.value() = " + annotation.value());
        Constructor<?> constructor = clazz.getConstructor(String.class);


        Method[] methods = clazz.getMethods();


        for (Method method : methods) {
            MethodAnnotation annotation1 = method.getAnnotation(MethodAnnotation.class);

            if (null != annotation1) {

                for (Parameter parameter : method.getParameters()) {

                    // 参数的名称
                    System.out.println("parameter.getName() = " + parameter.getName());

                    // 参数的类型
                    System.out.println("parameter.getType() = " + parameter.getType());

                    Class<?> type = parameter.getType();

                    Class<? extends Parameter> aClass = parameter.getClass();
                    String a = "111111111";
                    Object o = type.newInstance();
                    if (a instanceof String) {

                        System.out.println("OK");
                    }




                }



                // 调用 method的方法
                method.invoke(clazz2,"调用 method的方法");


                System.out.println(annotation1.value());
            }
        }
    }
}
