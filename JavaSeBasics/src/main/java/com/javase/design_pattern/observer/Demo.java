package com.javase.design_pattern.observer;

/**
 * TODO
 *
 * @date:2019/12/3 22:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        MyObservable observable = new MyObservable();

        observable.addObserver(new MyObserver("tom"));
        observable.addObserver(new MyObserver("tony"));

        observable.setChanged();

        observable.notifyObservers("安星是个傻逼");

    }

}
