package com.javase.Keyword.extend_practice;


import com.javase.Keyword.extend_practice.final_method_extend.JavaBean;

/**
 * TODO
 *
 * @date:2019/9/23 13:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo02 {



    public static void main(String[] args) {
        new Son();
    }

}

class Person{
    static {
        System.out.println("父类 静态代码块");
    }

    {
        System.out.println("父类 非静态代码块");
    }

    public Person() {
        System.out.println("父类 构造器");
    }
}
class Son extends Person{
    static {
        System.out.println("子类 静态代码块");
    }

    {
        System.out.println("子类 非静态代码块");
    }

    public Son() {
        System.out.println("子类 构造器");
    }
}