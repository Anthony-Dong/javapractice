package com.javase.iterator;

import java.util.*;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @date:2019/10/23 20:21
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestIterator {


    public static void main(String[] args) {


        ArrayList<Object> list = new ArrayList<>();




        Iterator<String> iterator = new Iterator<String>() {
            int x = 10;


            @Override
            public boolean hasNext() {
                x--;
                return x>0;
            }

            @Override
            public String next() {
                return new Random().nextInt(10)+"";
            }
        };




        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

    }


}
