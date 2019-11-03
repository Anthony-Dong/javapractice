package com.javase.package_info;


import java.util.HashSet;

/**
 * package_info的作用
 *
 * @date:2019/9/15 12:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        String a = "a";
        String b = new String("a");

        HashSet<String> objects = new HashSet<>();


        objects.add(a);
        objects.add(b);

        System.out.println(objects.size());

        System.out.println(a==b);

    }
}
