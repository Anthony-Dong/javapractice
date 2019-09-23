package com.lock.ReetrantLock_test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @date:2019/9/22 15:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoReentrantLock {


    private static  ReentrantLock lock = new ReentrantLock();


    public static class Task implements Runnable{
        private  static   int x = 0;

        private static  Boolean flag = true;

        @Override
        public  void run() {
            while (flag) {
                lock.lock();  // block until condition holds
                try {
                    x++;
                    System.out.println(Thread.currentThread().getName()+" : "+x);
                    if (x == 10000) {
                        flag = false;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {




        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 15, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
//
        pool.execute(new Task());
        pool.execute(new Task());
        pool.execute(new Task());
        pool.execute(new Task());
//        pool.execute(new Task());
       pool.shutdown();
        if (! pool.awaitTermination(100,TimeUnit.SECONDS)) {
            pool.shutdown();

        }

//
//        Thread thread = new Thread(new Task(), "thread-1");
//        Thread thread2 = new Thread(new Task(), "thread-2");
//        Thread thread3 = new Thread(new Task(), "thread-3");
//
//        thread.start();
//        thread2.start();
//        thread3.start();

    }
}
