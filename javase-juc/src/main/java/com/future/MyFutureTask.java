package com.future;

import java.util.concurrent.*;

/**
 *
 *
 * @date:2019/10/6 23:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyFutureTask<T> implements Runnable {

    // 关键之处
    private  volatile int state;

    // 状态 ,没有考虑太多状态
    private  static final int NEW          = 0;
    private  static final int COMPLETING   = 1;

    // Callable 对象 , 其call()方法其实就是有一个返回值的方法罢了
    private Callable<T> callable;


    public MyFutureTask(Callable<T> callable) {
        this.callable = callable;
        this.state = NEW;
    }


    // 结果
    public T t;


    // 获取结果
    public T get() {

        // 关键代码 , 死循环 啥也不做 , 就是让线程阻塞 , 利用了volatile 的特性 ,
        // 让执行get的线程不断去拉去state状态
        while (state < COMPLETING) {

        }
        return this.t;
    }

    /**
     * 重写 run 方法 , 就是实现了 runnable接口 ,
     *  执行 调用 call 方法 , 将返回值返回 .
     *  所以 Callable 其实就是一个 event源,只是有返回值而已
     */
    @Override
    public void run() {
        try {
            // 调用 call 方法
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
