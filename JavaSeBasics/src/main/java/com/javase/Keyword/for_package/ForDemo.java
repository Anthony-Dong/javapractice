package com.javase.Keyword.for_package;

/**
 * for 循环 执行的特点  1 2 do  3 2 do 3 2 do  3 2 false
 *
 * @date:2019/9/6 22:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ForDemo {

    public static void main(String[] args) {
        int i=0;
        for (foo("222222"); foo("111111")&&i<10; i++) {

            System.out.println("111111111111");

        }

    }

    static boolean foo(String name){
        System.out.println(name);

        return true;
    }
}
