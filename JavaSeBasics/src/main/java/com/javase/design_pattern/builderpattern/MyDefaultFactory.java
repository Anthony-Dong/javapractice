package com.javase.design_pattern.builderpattern;

/**
 * TODO
 *
 * @date:2019/9/6 23:21
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyDefaultFactory implements MyFactory {

    private String config;

    public MyDefaultFactory(String config) {
        this.config = config;
    }

    @Override
    public MyProduct create() {
        return new MyDefaultProduct(config);
    }
}
