package com.javase.designpattern.decorate;

/**
 * 我是觉得 设置为 抽象类 不能直接实现比较好  缓冲层
 *
 * @date:2019/9/7 18:00
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public abstract class Decorate extends Drink {

    //放入被装饰的对象 coffee //这里为什么不适用 coffee 呢
    // 因为 可能多重装饰 重复放料
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    float cost() {
        //1 . 自己的价格  +  饮品的花费
        return super.getPrice() + drink.cost();
    }


    @Override
    public String getDesc() {
        return super.getDesc() + "价格:" + super.getPrice()+"一共花费:"+cost();
    }
}
