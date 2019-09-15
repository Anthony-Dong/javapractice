package com.javase.Keyword.collection;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * TODO
 *
 * @date:2019/9/11 20:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class SetQuestion {

    public static void main(String[] args) {

        TreeSet<Integer> objects = new TreeSet<>();

        objects.add(250);
        objects.add(250);
        objects.add(200);
        objects.add(200);
        objects.add(3000);
        System.out.println(objects.size());

        objects.forEach(System.out::println);


        TreeSet<Cat> objects1 = new TreeSet<>();

        objects1.add(new Cat(1));
        objects1.add(new Cat(2));
        objects1.add(new Cat(3));
        objects1.add(new Cat(4));
        System.out.println(objects1.size());

        objects1.forEach(System.out::println);


        ConcurrentHashMap objectObjectConcurrentHashMap = new ConcurrentHashMap();

        new HashSet<>();

        ConcurrentHashSet<Object> objects2 = new ConcurrentHashSet<>();

        System.out.println("-----------------------");
        CopyOnWriteArraySet<Cat> cats = new CopyOnWriteArraySet<>();


        cats.add(new Cat(1));
        cats.add(new Cat(1));
        cats.add(new Cat(2));
        cats.add(new Cat(3));

        cats.forEach(System.out::println);

//
//        CopyOnWriteArraySet<Integer> set = new CopyOnWriteArraySet<>();
//        set.add(100);
//        set.add(300); set.add(100);
//        set.add(200);
//        set.add(200);
//
//        set.forEach(System.out::println);


        ConcurrentHashSet<Cat> catss = new ConcurrentHashSet<>();

        catss.add(new Cat(1));
        catss.add(new Cat(1));
        catss.add(new Cat(2));
        catss.add(new Cat(3));
        System.out.println(catss.size());
    }


    private static class Cat implements Comparable{
        @Override
        public String toString() {
            return "cat:"+this.getInteger();
        }

        public Cat(Integer integer) {
            this.integer = integer;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        private Integer integer;

        public Integer getInteger() {
            return integer;
        }

        public void setInteger(Integer integer) {
            this.integer = integer;
        }

        @Override
        public int compareTo(Object o) {
            return getInteger();
        }


//
//        @Override
//        public int hashCode() {
//
//            return getInteger();
//        }
    }
}
