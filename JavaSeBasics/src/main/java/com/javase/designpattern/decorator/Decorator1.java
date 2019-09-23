package com.javase.designpattern.decorator;

/**
 * TODO
 *
 * @date:2019/9/16 17:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Decorator1 extends Decorator {


    public Decorator1(Component component) {
        super(component);
    }

    @Override
    public void doSomething() {
        super.doSomething();

        this.doAnotherThing();
    }


    public void doAnotherThing(){
        System.out.println("功能B");
    }

}
