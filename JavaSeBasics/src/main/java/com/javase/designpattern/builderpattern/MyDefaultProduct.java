package com.javase.designpattern.builderpattern;

/**
 * TODO
 *
 * @date:2019/9/6 23:23
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyDefaultProduct implements MyProduct{


    private String config;

    public MyDefaultProduct(String config) {
        this.config = config;
    }

    @Override
    public String show() {

        return this.config;
    }
}
