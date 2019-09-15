package com.javase.day01.abstractAndInterface;

/**
 * ClassName:ClassA
 * Package:com.javase.day01.abstractAndInterface
 * Description:
 *
 * @date:2019/6/28 10:25
 * @author: 574986060@qq.com
 */

public interface  ClassI {

    /**
     * 成员变量 必须有值
     * 可以有 static方法
     * 也可以 有default 方法
     *
     */
    String a = "1";
    static void method02(){
        System.out.println("static void method02()");
        System.out.println(a);
    }

    default void me(){
        System.out.println("default void me()");
    }
}
