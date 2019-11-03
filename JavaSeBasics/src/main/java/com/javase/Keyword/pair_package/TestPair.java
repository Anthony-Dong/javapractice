package com.javase.Keyword.pair_package;

import javafx.util.Pair;

/**
 * TODO
 *
 * @date:2019/10/14 19:58
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestPair {


    static Pair<String, Integer> integerPair = new Pair<>("key", 1);

    static org.apache.commons.lang3.tuple.Pair<String, String> pair = org.apache.commons.lang3.tuple.Pair.of("key", "value");


    public static void main(String[] args) {
        System.out.println("integerPair.getKey() = " + integerPair.getKey());

        System.out.println("integerPair.getValue() = " + integerPair.getValue());

        System.out.println(pair.getLeft() + "" + pair.getRight());

        int i = 1;
        int j = 1;

        System.out.println(""+i + j+"");
    }





}
