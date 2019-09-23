package com.javase.designpattern.decorator;

/**
 * 装饰角色实现抽象构建角色同时实现他的引用
 *
 *
 * @date:2019/9/16 17:26
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Decorator implements Component{
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }


    @Override
    public void doSomething() {
        this.component.doSomething();
    }
}
