package com.javase.designpattern.builderpattern;

/**
 *  SqlSessionFactoryBuilder
 *
 * @date:2019/9/6 23:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyBuilder {


    public MyFactory build(String config) {
        return new MyDefaultFactory(config);
    }

    public MyFactory build(String config, String con) {

        return build(con + config);
    }
}
