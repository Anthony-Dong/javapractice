package com.javase.class_package.clazz;

/**
 * TODO
 *
 * @date:2019/10/15 9:56
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestGetClass {


    public static void main(String[] args) {

        Person person = new Son();


        Son son = (Son) person;


        System.out.println(son.getClass().getName()+person.getClass().getName());
    }


}

class Person{

}
class Son extends Person{

}
