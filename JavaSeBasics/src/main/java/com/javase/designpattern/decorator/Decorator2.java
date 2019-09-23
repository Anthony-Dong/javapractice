package com.javase.designpattern.decorator;

/**
 * TODO
 *
 * @date:2019/9/16 17:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Decorator2 extends Decorator {


    public Decorator2(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();
        this.doAnotherThing();
    }

    private void doAnotherThing(){
        System.out.println("功能C");
    }
}
