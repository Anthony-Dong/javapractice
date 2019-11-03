package com.javase.design_pattern.interface_adapter;

/**
 * TODO
 *
 * @date:2019/9/7 12:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {

        MyAbstract myAbstract = new MyAbstract(){
            @Override
            public void m1() {
                System.out.println("我只要  m1 方法");
            }
        };


        myAbstract.m1();
    }


}
