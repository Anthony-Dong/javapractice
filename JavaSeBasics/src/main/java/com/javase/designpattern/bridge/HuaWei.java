package com.javase.designpattern.bridge;

/**
 * TODO
 *
 * @date:2019/9/7 16:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class HuaWei implements NationalBrand{


    @Override
    public void noladder() {
        System.out.println("我不能翻墙");
    }

    @Override
    public void call() {
        System.out.println("我是huawei手机");
    }
}
