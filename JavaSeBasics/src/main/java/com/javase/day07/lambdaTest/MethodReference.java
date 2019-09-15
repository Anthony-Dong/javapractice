package com.javase.day07.lambdaTest;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ClassName:MethodReference
 * Package:com.javase.day07.lambdaTest
 * Description:
 *
 * @date:2019/7/11 21:59
 * @author: 574986060@qq.com
 */

public class MethodReference {

    @Test
    public void test01(){
        PrintStream os = System.out;
        Consumer<Object> consumer1 = (x) -> System.out.println(x);
        Consumer<Object> consumer2 = System.out::println;
        Consumer<Object> consumer =os::println;
        consumer.accept(111);
        consumer1.accept("你个大傻吊");

        Function<Integer, Integer> function = (x) -> x * 100;
        consumer2.accept(function.apply(100));

        Person person = new Person();
        person.setName("小垃圾");
        Supplier<String> supplier =person::getName;
        consumer.accept(supplier.get());

        Comparator<Integer> comparator = Integer::compareTo;
        Boolean aBoolean=comparator.compare(100, 50) == 1 ? true :false;
        System.out.println(aBoolean);

        Supplier<Person> supplier1 = Person::new;
        Person person1 = supplier1.get();
    }

}
