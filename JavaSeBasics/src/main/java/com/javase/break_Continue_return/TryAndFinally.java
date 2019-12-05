package com.javase.break_Continue_return;

import java.lang.reflect.InvocationTargetException;

/**
 *
 *
 * @date:2019/11/20 16:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TryAndFinally {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class.forName("com.javase.break_Continue_return.A").getConstructor(String.class).newInstance("儿子");

        System.out.println("====================");

        Object o1 = TryAndFinally.class.getClassLoader().loadClass("com.javase.break_Continue_return.A").getConstructor(String.class).newInstance("儿子");



    }

}
class A{

    private String x;

    public A(String x) {
        this.x = x;
        System.out.println(x);
    }

    public A() {
    }

    static {
        System.out.println("傻逼");
    }

    {
        System.out.println("shabi");
    }

}
