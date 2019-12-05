package com.stack;


import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/27 16:33
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestStack {

    private static final Object LOCK = new Object();


    public static void main(String[] args) {

        new Thread(() -> {
            // sync 和 wait 必须是同一个对象 , 不然会抛出  IllegalMonitorStateException
            synchronized (LOCK) {
                try {
                    System.out.println("我执行 wait : " + Thread.currentThread().getName());
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我被释放了 : " + Thread.currentThread().getName());
            }
        }).start();


        new Thread(() -> {
            synchronized (LOCK) {
                System.out.println("我执行 notify : " + Thread.currentThread().getName());
                LOCK.notifyAll();
            }
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我通知了 : " + Thread.currentThread().getName());
        }).start();

    }


}
