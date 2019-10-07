package com.future_question;

import java.io.IOException;
import java.io.InputStream;
import java.util.EventListener;
import java.util.EventObject;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * TODO
 *
 * @date:2019/10/6 23:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyFutureTask<T> implements Runnable {

    private volatile int state;
    private static final int NEW          = 0;
    private static final int COMPLETING   = 1;


    private Callable callable;

    private  Thread thread;



    // 监听器  这里不使用
    interface MyEventListener extends EventListener {
        EventObject submit(EventObject object);
    }

    // 监听对象
    class Myeventobject extends EventObject{
        public Myeventobject(Object source) {
            super(source);
        }
    }


    public MyFutureTask(Callable callable) {
        this.callable = callable;
        this.state = NEW;
    }


    // 结果
    public T t;


    // 获取结果
    public T get() {

        // 死循环 啥也不做  就是让线程阻塞 ,去掉试试呢
        while (state < COMPLETING) {

        }
        return this.t;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            this.thread = Thread.currentThread();
            // 执行完成
            Object call = callable.call();
            // 给结果赋值
            this.t = (T)call;
            // 然后改变状态
            this.state = COMPLETING;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
