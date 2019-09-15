package com.javase.day04;

/**
 * ClassName:DoWrapperClass
 * Package:com.javase.day04
 * Description:
 *
 * @date:2019/7/2 9:50
 * @author: 574986060@qq.com
 */

public class DoWrapperClass {

    public static void main(String[] args) {
        /**
         *  -128,127 之间就放在常量池里  不会new出 新的对象  直接引用常量池中的
         *
         *
         */
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

    }
}
