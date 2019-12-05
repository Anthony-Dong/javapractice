package com.stack;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/29 10:56
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestJoin {


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(TestJoin::task);
        Thread thread1 = new Thread(TestJoin::task);
        Thread thread2 = new Thread(TestJoin::task);

        thread.start();
        thread.join();
        thread1.start();
        thread1.join();

        thread2.start();
        thread2.join();

        System.out.println(System.currentTimeMillis() - start);
    }

    public static void blocking(Thread thread) throws InterruptedException {
        if (thread.getState() == Thread.State.NEW) {
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " : 阻塞中");

        synchronized (thread) {
            thread.wait();
            System.out.println("我被释放了 : " + Thread.currentThread().getName());
        }
    }

    public static void task() {
        System.out.println(Thread.currentThread().getName() + ": 执行任务");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
