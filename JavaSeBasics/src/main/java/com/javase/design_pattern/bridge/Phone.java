package com.javase.design_pattern.bridge;

/**
 * 这个就是桥
 *
 * @date:2019/9/7 16:46
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public abstract class Phone {

    private Brand brand;


    public Phone(Brand brand) {
        this.brand = brand;
    }

    void method(){
        this.brand.call();
    }
}
