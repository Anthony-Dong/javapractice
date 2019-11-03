package com.javase.design_pattern.adapter;

/**
 * 这里是一个需求方
 *
 * @date:2019/9/7 11:14
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyPhone {


    public void charge(MyAdapter myAdapter) {

        int i = myAdapter.myOutput();

        System.out.println("充电电压为"+i+"伏");
    }


    public void objectCharge(ObjectAdapter objectAdapter) {

        int output = objectAdapter.myOutput();

        System.out.println("充电电压为"+output+"伏");
    }

}
