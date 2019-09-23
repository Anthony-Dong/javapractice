package com.javase.java8_new_feature.lambdaTest;

/**
 * ClassName:FunctionalInterface
 * Package:com.javase.java8_new_feature.lambdaTest
 * Description:
 *
 * @date:2019/7/11 21:24
 * @author: 574986060@qq.com
 */

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置的函数式接口
 * consumer
 *
 */
public class FunctionalInterface {

    /**
     * consumer<T></>  消费型接口 有参数 无返回值
     * 其中  void accept（T）
     */
    @Test
    public void test01(){
        peopleConsumer(100.1,(m)-> System.out.println("消费了"+m));
    }
    public void peopleConsumer(Double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    /**
     * supplier  供给型 接口   不用传入参数 ；直接返回一个数值
     */
    @Test
    public void test02(){
        List<Integer> integers = supplyTest(10, () -> new Random().nextInt(10));
        System.out.println(Arrays.toString(integers.toArray()));

    }

    public List<Integer> supplyTest(Integer num, Supplier<Integer> supplier) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            integers.add(supplier.get());
        }
        return integers;
    }

    /**
     * Function<T, R>  接口 函数型接口
     * R apply(T t);  传入一个T 传出一个R
     */
    @Test
    public void test03(){
        System.out.println(functionTest("   aaaa", (e) -> e.trim()));
    }

    public String functionTest(String string, Function<String, String> function) {
        return function.apply(string);
    }

    /**
     * Predicate<T>   断言性接口
     *  boolean test(T t);  可以进行判断
     */
    @Test
    public void test04() {
        List<Integer> list = new ArrayList<>();
        list.add(800);
        list.add(900);
        list.add(200);
        list.add(300);

//        List<Integer> integers = predicateTest02(list);
        List<Integer> integers = predicateTest(list, (i) -> i > 500);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> predicateTest(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> list1 = new ArrayList<>();

        for (Integer integer : list) {
            if (predicate.test(integer)) {
                list1.add(integer);
            }
        }
        return list1;
    }


    public List<Integer> predicateTest02(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();

        for (Integer integer : list) {
            if (integer>500) {
                list1.add(integer);
            }
        }
        return list1;
    }
}

