package com.javase.java8_new_feature.lambda_vs_methodReference;

/**
 * TODO
 *
 * @date:2019/9/20 14:11
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public void play() {
        int x=4;
        class InTest{
            public void f() {
                System.out.println(x);
            }
        }
        new InTest().f();
    }
    public static void main(String[] args) {
        Demo t=new Demo();
        t.play();

    }
}
