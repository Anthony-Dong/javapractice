package com.javase.day05;

/**
 * ClassName:TestDo
 * Package:com.javase.day05
 * Description:
 *
 * @date:2019/7/3 15:13
 * @author: 574986060@qq.com
 */

public class Test {
    public static void main(String[] args) {
        System.out.println(sum(4));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }else
            return n + sum(n-1);
    }
}
