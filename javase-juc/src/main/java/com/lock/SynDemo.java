package com.lock;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynDemo {

    public static void main(String[] arg)  {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 15, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5));
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.execute(new MyThread());
        pool.shutdown();
    }
}

class MyThread implements Runnable {
    private static  int x = 0;

    @Override
    public synchronized  void run() {
        synchronized (this) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ":" + (++x));
                if (x == 100) {
                    break;
                }
            }
        }
    }
}

