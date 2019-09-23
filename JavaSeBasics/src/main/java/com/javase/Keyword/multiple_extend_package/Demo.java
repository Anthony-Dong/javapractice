package com.javase.Keyword.multiple_extend_package;

/**
 *  引用间接超类的字段时;可以使用向上转型
 *  引用直接超类时,可以使用super转型
 *
 * @date:2019/9/16 11:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {
        C c = new C();
        System.out.println("c.x = " + c.x);
        c.get();
    }
}

class A{
    int x=5;
}

class B extends A{
    int x=6;
}

class C extends  B{
    int x=7;
    public void get(){
        System.out.println(((A)this).x);
        System.out.println(((B)this).x);
        System.out.println(super.x);
        System.out.println(this.x);

    }
}
