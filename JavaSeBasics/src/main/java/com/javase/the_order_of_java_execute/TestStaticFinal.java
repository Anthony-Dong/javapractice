package com.javase.the_order_of_java_execute;

/**
 * TODO
 *
 * @date:2019/10/27 16:33
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestStaticFinal {


    public static final int x = 1;

    static {
        System.out.println("TestStaticFinal : 执行静态代码块1");
    }

    static {
        System.out.println("TestStaticFinal : 执行静态代码块2");
    }
}
