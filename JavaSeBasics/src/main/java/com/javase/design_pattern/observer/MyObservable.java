package com.javase.design_pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 *
 *
 * @date:2019/12/3 22:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyObservable extends Observable {

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }
}
