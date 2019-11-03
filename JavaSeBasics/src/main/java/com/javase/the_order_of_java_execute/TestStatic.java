package com.javase.the_order_of_java_execute;

/**
 * TODO
 *
 * @date:2019/10/27 16:33
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestStatic {

    public int x = 1;

    public static int x1 = 1;


    public TestStatic() {
    }

    public TestStatic(int x) {
        this.x = x;
    }


    {
        System.out.println("TestStatic : 执行非静态代码块");
    }

    static {
        System.out.println("TestStatic : 执行静态代码块1");
    }

    public static int x2 = 1;

    static {
        System.out.println("TestStatic : 执行静态代码块2");
    }

    public static final int x3 = 1;


    public static void staticMethod(){
        System.out.println("staticMethod");
    }


    public  void ordinaryMethod(){
        System.out.println("ordinaryMethod");
    }
}
