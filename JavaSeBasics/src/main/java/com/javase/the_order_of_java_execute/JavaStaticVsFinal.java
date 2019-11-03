package com.javase.the_order_of_java_execute;

/**
 * TODO
 *
 * @date:2019/10/27 16:33
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class JavaStaticVsFinal {

    public static void main(String[] args) {
        System.out.println("TestStatic.x = " + TestStatic.x1);
        System.out.println("TestStatic.x = " + TestStatic.x2);

        System.out.println("===========================");

        System.out.println("TestStatic.x = " + TestStaticFinal.x);
    }
}
