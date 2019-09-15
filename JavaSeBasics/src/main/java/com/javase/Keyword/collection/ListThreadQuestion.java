package com.javase.Keyword.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO
 *
 * @date:2019/9/11 19:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ListThreadQuestion {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.set(2, 5);
//        integers.add(6);
        integers.forEach(System.out::println);

        List<Integer> integers1 = Collections.synchronizedList(integers);
        integers1.set(2, 10);
        integers1.forEach(System.out::println);


        CopyOnWriteArrayList<Integer> integers2 = new CopyOnWriteArrayList<>();

        Integer[] list1 = new Integer[]{1, 2, 3, 4, 5};

        Integer[] list = new Integer[10];


        System.arraycopy(list1, 0, list, 0, 4);


        Vector<Object> objects = new Vector<>();

        objects.add("11111");


        for (Integer integer : list) {
            System.out.println(integer);
        }


        Integer[] integers3 = Arrays.copyOf(list1, 10);

        System.out.println(integers3.length);
        for (Integer integer : integers3) {
            System.out.println(integer);
        }

//        integers1.add(10);
    }

}
