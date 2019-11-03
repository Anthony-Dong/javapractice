package com.threadstatus;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @date:2019/10/27 14:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestThreadStatus {
    final static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        // 1. 未启动状态 属于 new
        Thread thread = new Thread(()->{
            int i = 10;
            for (int i1 = 0; i1 < i; i1++) {
                get();
            }
        });
        thread.start();

        // 启动后属于  RUNNABLE
        Thread.sleep(100);


    }


    public static void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getState());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
