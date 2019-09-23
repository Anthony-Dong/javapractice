package com.javase.java8_new_feature.lambdaTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * ClassName:LambdaTest
 * Package:com.javase.java8_new_feature.lambdaTest
 * Description:
 *
 * @date:2019/7/11 16:45
 * @author: 574986060@qq.com
 */

public class LambdaTest {

    @Test
    public void test01(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> tree = new TreeSet<>(com);
        tree.add(2);
        tree.add(1);
        System.out.println(tree);
    }
    @Test
    public void test02(){
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void test03(){
        Integer operation = operation(100, value -> value * value);
        System.out.println(operation);
    }

    public Integer operation(Integer num, MyFun fun) {
        return fun.reValue(num);
    }
}
