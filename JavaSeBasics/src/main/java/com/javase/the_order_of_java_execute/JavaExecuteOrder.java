package com.javase.the_order_of_java_execute;

/**
 * TODO
 *
 * @date:2019/10/27 16:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class JavaExecuteOrder {

    static JavaExecuteOrder order = new JavaExecuteOrder();


    public JavaExecuteOrder() {
        System.out.println("构造方法");
        System.out.println("x : "+x++);
        System.out.println("y : "+y++);
    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("非静态代码块1");
    }
    {
        System.out.println("非静态代码块2");
    }

    static int x = 1;

    int y = 2;

    public static void main(String[] args) {
        System.out.println("main 方法");
        new JavaExecuteOrder();
    }

}
