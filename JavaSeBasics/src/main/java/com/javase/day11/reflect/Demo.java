package com.javase.day11.reflect;

/**
 * ClassName:demos
 * Package:com.javase.day11.reflect
 * Description:
 *
 * @date:2019/8/6 22:26
 * @author: 574986060@qq.com
 */

public class Demo {

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        Class<? extends Demo> aClass = demo.getClass();
        Demo demo1 = aClass.newInstance();
        System.out.println(demo==demo1);
    }
}
