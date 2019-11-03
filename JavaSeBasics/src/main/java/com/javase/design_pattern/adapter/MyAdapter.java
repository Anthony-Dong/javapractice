package com.javase.design_pattern.adapter;

/**
 * 适配器一般要继承适配的src类 和实现被适配的类
 *
 * 继承使得耦合度变大 ,但是重写 增加了灵活性
 *
 * @date:2019/9/7 11:13
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyAdapter extends VoltageI220V implements Voltage5V {


    @Override
    public int myOutput() {
        System.out.println("我执行了变压操作,我是一个继承src的适配器");
        return output() / 44;
    }
}
