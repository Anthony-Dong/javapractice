package com.javase.day02.enumtest;



/**
 * ClassName:SwitchDemo
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 11:10
 * @author: 574986060@qq.com
 */

public class SwitchDemo {

    public static void main(String[] args) {
        for (EnumTest e : EnumTest.values()) {
            System.out.println(e.toString());
        }

        System.out.println("----------------我是分隔线------------------");

        EnumTest test = EnumTest.TUE;
        switch (test) {
            case MON:
                System.out.println("今天是星期一");
                break;
            case TUE:
                System.out.println("今天是星期二");
                break;
            // ... ...
            default:
                System.out.println(test);
                break;

        }

    }



}
