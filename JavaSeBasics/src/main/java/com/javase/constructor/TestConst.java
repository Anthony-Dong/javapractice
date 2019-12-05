package com.javase.constructor;

/**
 *
 *
 * @date:2019/11/19 17:43
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestConst {


    public static void main(String[] args) {
        new B(new A());
    }

}

class A {

    public A() {
        System.out.println("执行一次");
    }
}

class B {

    private  final A a ;

    public B(A a) {
        this.a = a;
    }

}
