package com.javase.Keyword.extend_practice.final_method_extend;

/**
 * TODO
 *
 * @date:2019/9/10 12:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {

        Person person = new Son();
        person.m1();

        ((Son) person).m3();


        Son son = new Son();
        son.m1();

        son.m2();
    }

}

class Person{
    public Integer num;

    public Person(Integer num) {
        this.num = num;
        System.out.println("我是父类带参构造器");
    }

    public Person() {
        System.out.println("我是父类默认构造器");
    }

     void m1(){
        System.out.println(" p m1");
    }

    void m2(){
        System.out.println(" p  m2");
    }
}

class Son extends  Person{
    private Integer num = 2;
    public Son() {
          System.out.println("我是子类的默认构造器");
        System.out.println(this.num);
        System.out.println(((Person) this).num);
    }

    @Override
    void m1() {
        System.out.println(" s m1");
    }


    void m3(){
        System.out.println(" s m3 ");
    }
}