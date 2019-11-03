package com.javase.Java_Object_Oriented.extend;

public class Demo {

    public static void main(String[] args) {
        Son son = new Son();

        son.m1();

    }
}

class Person{
    protected Person() {
        super();
        System.out.println("我是父类默认构造器");
    }

    public void m1(){
        System.out.println("p : m1");
    }
}

class Son extends  Person{
    public Son() {
        super();
        System.out.println("我是子类默认构造器");
    }

    public void m2(){
        System.out.println("s : m2");
    }
}