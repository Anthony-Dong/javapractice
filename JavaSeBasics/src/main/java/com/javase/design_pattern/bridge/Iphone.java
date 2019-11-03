package com.javase.design_pattern.bridge;

/**
 * TODO
 *
 * @date:2019/9/7 16:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Iphone implements AbroadBrand{


    @Override
    public void ladder() {
        System.out.println("我能翻墙");
    }

    @Override
    public void call() {
        System.out.println("我是手机");
    }
}
