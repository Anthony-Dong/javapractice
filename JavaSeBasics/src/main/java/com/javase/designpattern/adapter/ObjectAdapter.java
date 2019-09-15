package com.javase.designpattern.adapter;

/**
 * 他 呢 把继承关系 改成 聚合关系,增加了  低耦合的关系
 *
 * @date:2019/9/7 11:22
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ObjectAdapter implements Voltage5V {
    private VoltageI220V v;

    public ObjectAdapter(VoltageI220V v) {
        this.v = v;
    }

    @Override
    public int myOutput() {
        System.out.println("我执行了变压操作 ,我是一个类适配器");
        return v.output() / 44;
    }
}
