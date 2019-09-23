package com.javase.java8_new_feature.fork_join;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * TODO
 *
 * @date:2019/9/19 22:53
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo3 {

    public static void main(String[] args) {


        List<Integer> lists = new ArrayList<>();


        lists.add(1);
        ArrayList<Integer> collect = lists.stream().collect(Collectors.toCollection(ArrayList::new));


        System.out.println("res " + LongStream.range(1, 10).reduce(0,(a, b) -> {
            return a + b;
        }));


        ArrayList<Integer> collect1 = IntStream.range(1, 5).collect(ArrayList::new, ArrayList::add, (arrayList, arrayList2) -> {});


        collect1.forEach(System.out::println);


    }

}
