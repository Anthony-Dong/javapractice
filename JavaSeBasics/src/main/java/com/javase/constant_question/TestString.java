package com.javase.constant_question;

/**
 * TODO
 *
 * @date:2019/11/16 13:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestString {


    public static void main(String[] args) {
        String string = new StringBuilder("计算机").append("软件").toString();


        System.out.println(string.intern() == string);


        String string2 = new StringBuilder("js").append("tj").toString();

        String string3="jstj";

        System.out.println(string2.intern() == string3);
        System.out.println(string2 == string3);
    }


}
