package com.javase.design_pattern.adapter;

/**
 * com.demo
 *
 * @date:2019/9/7 11:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {

        MyPhone myPhone = new MyPhone();

        myPhone.charge(new MyAdapter());
        System.out.println("-----------------------------");


        myPhone.objectCharge(new ObjectAdapter(new VoltageI220V()));
    }


}
