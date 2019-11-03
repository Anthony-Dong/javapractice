package com.javase.design_pattern.decorate;

/**
 * 我的小料 装饰
 *
 * @date:2019/9/7 18:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyDecorate extends Decorate {


    public MyDecorate(Drink coffee) {
        super(coffee);
        setDesc("我的小料");
        setPrice(500);
    }
}
