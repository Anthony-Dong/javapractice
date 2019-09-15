package com.javase.day01.clone;

/**
 * ClassName:CloneTest
 * Package:com.javase.day01
 * Description:
 *
 * @date:2019/6/28 9:26
 * @author: 574986060@qq.com
 */

public class CloneTest {

    public static void main(String[] args) {
        //P和P1的地址相同
        Person person = new Person();

        Person person1 = person;
        System.out.println(person);
        System.out.println(person1);





    }
}
