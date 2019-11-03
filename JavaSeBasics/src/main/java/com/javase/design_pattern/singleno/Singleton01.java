package com.javase.design_pattern.singleno;

/**
 * ClassName:Singleton01
 * Package:com.javase.design_pattern.singleno
 * Description:   直接 静态代码块 实现 饿汉式
 *
 * @date:2019/9/6 18:04
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Singleton01 {

    private  static final Singleton01 singleton ;

    static{
        singleton = new Singleton01();
    }

    private Singleton01(){}

    public  static Singleton01 getSingleton(){
        return singleton;
    }


    public static void main(String[] args) {
        Singleton01 singleton = Singleton01.getSingleton();
        Singleton01 singleton1 = Singleton01.getSingleton();

        System.out.println(singleton == singleton1);
    }
}
