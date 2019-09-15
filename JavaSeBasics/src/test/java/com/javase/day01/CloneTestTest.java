package com.javase.day01;

import com.javase.day01.clone.Person;
import com.javase.day01.clone.PersonDeep;
import org.junit.Test;

/**
 * ClassName:CloneTestTest
 * Package:com.javase.day01
 * Description:
 *
 * @date:2019/6/28 9:39
 * @author: 574986060@qq.com
 */

public class CloneTestTest {

    @Test
    public void test01(){
        /**
         * 不去 new对象就是等于地址不变
         *
         */
        //P和P1的地址相同
        Person person = new Person();

        Person person1 = person;
        System.out.println(person);
        System.out.println(person1);

    }
    @Test
    public void test02() throws CloneNotSupportedException {
        //P和P1的地址就不相同了  实现 cloneable接口
        //1645995473
        //1463801669
        //752566
        //752566
        //可以 发现 clone 是浅拷贝
        Person person = new Person();

        person.setName("安星");

        Person person1 = (Person) person.clone();
        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());

        System.out.println(person.getName().hashCode());
        System.out.println(person1.getName().hashCode());

    }

    @Test
    public void test03() throws CloneNotSupportedException {
        //P和P1的地址就不相同了  实现 cloneable接口
       /* 1645995473
        1463801669
        752566
        752566*/
        //可以 发现 clone 是深拷贝  需要拷贝 属性的
        Person person = new Person();
        PersonDeep personDeep = new PersonDeep();

        personDeep.setPerson(person);

        PersonDeep person1 = (PersonDeep) personDeep.clone();
        System.out.println(personDeep.hashCode());
        System.out.println(personDeep.hashCode());

        System.out.println(personDeep.getPerson().hashCode());
        System.out.println(personDeep.getPerson().hashCode());

    }


}