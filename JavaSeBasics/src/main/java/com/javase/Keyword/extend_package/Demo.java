package com.javase.Keyword.extend_package;

/**
 * 向上转型会丢失 子类的方法,必须再向下转型才可以执行子类的方法
 *
 * 当子类重写父类的方法 ,向上转型也会执行子类重写的方法
 *
 * 如何调用一个类的成员变量 ,static直接调用 , Person.integer;
 * 普通调用就是 person.integers;
 *
 *
 *  int 默认值为0
 *  integer 默认值为 null
 *
 * @date:2019/9/6 23:39
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        Person person = new Son();

        person.show();


        Integer i = Person.integer;
        Integer i1 = person.integers;

        System.out.println(i);
        System.out.println(i1);

        Son son = (Son) person;



        Integer integer = Son.integer;

        Integer integers = son.integers;



        System.out.println(integer);

        System.out.println(integers);
        son.show();
        son.show();




    }


}
