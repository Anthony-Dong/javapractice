package com.javase.day02;

import com.javase.day01.clone.Person;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:EqualsDemoTest
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 9:55
 * @author: 574986060@qq.com
 */

public class EqualsDemoTest {

    @Test

    public void test01() {
        /**
         * ==  在对于 引用数据类型时  ；比较的是地址
         * .equals比较的是  其数值
         */
        String a = new String("a");
        String b = a;

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        System.out.println(a==b);
         b = "11";
        System.out.println(b.hashCode());


        b = "DD";
        System.out.println(b.hashCode());


        Person person = new Person();
        Person person1 = person;
        person.setName("AAA");
        person1.setName("BBB");

        System.out.println(person.getName());
        System.out.println(person1.getName());
        System.out.println(person1 == person);

        System.out.println(person1.equals(person));

    }
}