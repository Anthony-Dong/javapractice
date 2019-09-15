package com.javase.designpattern.decorate;

/**
 * 我是觉得 设置为 抽象类 不能直接实现比较好 ; 缓冲层
 *
 * @date:2019/9/7 17:57
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public abstract class Coffee extends Drink {



    // 就是咖啡的价格
    @Override
    float cost() {
       return super.getPrice();
    }


    @Override
    public String getDesc() {
        return super.getDesc() + "价格:" + super.getPrice()+"一共花费:"+cost();
    }
}
