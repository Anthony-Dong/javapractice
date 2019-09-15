package com.javase.designpattern.singleno;

/**
 * ClassName:Singleton
 * Package:com.javase.designpattern
 * Description:   静态内部类
 *
 * @date:2019/9/6 17:57
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Singleton {
    //3.构造方法私有化
    private Singleton(){}


    // 1.写一个静态内部类
    private static class SingletonInstance{
        private static final Singleton singleton = new Singleton();
    }

    // 2.实现加载
    public static Singleton getInstance(){
        return SingletonInstance.singleton;
    }



}
