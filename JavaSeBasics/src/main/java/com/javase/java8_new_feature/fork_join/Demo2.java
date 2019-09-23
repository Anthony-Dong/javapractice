package com.javase.java8_new_feature.fork_join;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO
 *
 * @date:2019/9/19 12:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo2 {

    public static void main(String[] args) {

/*        List<Integer> lists = new ArrayList<>();


        int i = 100000;
        for (int i1 = 0; i1 < i; i1++) {
            lists.add(i1);
        }



        Integer reduce2 = lists.parallelStream().reduce(1, (a, b) -> a + b);

        System.out.println(reduce2);


        HashSet<Object> objects = new HashSet<>();


        lists.parallelStream().forEach((e) -> {
            objects.add(e);
        });
        objects.parallelStream().forEachOrdered(System.out::println);*/



        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        System.out.println("------------------------------------");
        IntStream.range(1, 3).forEach(System.out::println);
        System.out.println("------------------------------------");
        IntStream.rangeClosed(1, 3).forEach(System.out::println);



        System.out.println("------------------------------------");
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
//Another way
//        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
//                limit(10).forEach(System.out::println);

        //清单 24. 生成一个等差数列
        Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));
    }


}
