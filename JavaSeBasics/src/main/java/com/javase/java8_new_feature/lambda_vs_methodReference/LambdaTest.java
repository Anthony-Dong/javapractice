package com.javase.java8_new_feature.lambda_vs_methodReference;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @date:2019/9/20 12:43
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class LambdaTest {



    public static void main(String[] args) {

        test02(() -> {
            System.out.println("1111111");
        });

        printName("哈哈哈", Person::new);

        printName("hhh", name -> new Person(name));
    }


    public static void test(Person p){

    }


    public static void test02(Function function){

        function.test();

        Function.method();
    }


    private static class  Task implements  Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void printName(String name,@NotNull PersonBuilder builder) {
        System.out.println(builder.buildPerson(name).getName());
    }

}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(){}

    public String getName() {
        return name;
    }
}
@FunctionalInterface
interface PersonBuilder {
    Person buildPerson(String name);
}


@FunctionalInterface
interface Function{
    void test();

    @Override
    String toString();


    default Function then(){

        return ()->{
            System.out.println("hhhhhhhhhhhh");
        };
    }

    static void  method(){
        System.out.println("111");
    }
}
