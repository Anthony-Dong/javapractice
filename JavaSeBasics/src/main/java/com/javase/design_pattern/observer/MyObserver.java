package com.javase.design_pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * TODO
 *
 * @date:2019/12/3 22:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyObserver implements Observer {

    private String name;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this.name+" 收到消息 : "+arg);
    }
}
