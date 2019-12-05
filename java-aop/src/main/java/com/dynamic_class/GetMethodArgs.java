package com.dynamic_class;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * TODO
 *
 * @date:2019/11/7 21:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class GetMethodArgs {



    public  void get(String args, String name) {

        System.out.println(args);

        System.out.println(name);

    }


    public static void main(String[] args) throws NoSuchMethodException {
        GetMethodArgs methodArgs = new GetMethodArgs();


        methodArgs.get("1111111", "222222222");



        Method get = methodArgs.getClass().getMethod("get",String.class,String.class);




        Parameter[] parameters = get.getParameters();


        for (Parameter parameter : parameters) {
            String name = parameter.getName();
            System.out.println("name = " + name);
        }

    }


}
