package com.javase.set;

import java.util.HashSet;

/**
 * TODO
 *
 * @date:2019/10/23 20:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSet {


    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();


        integers.add(1);

        Object[] objects = integers.toArray();

        for (Object object : objects) {
            System.out.println(object.getClass().getName());
        }

    }


}
