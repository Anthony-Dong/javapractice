package com.lock.ReadWriteLock_test;

import java.security.SecureRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 * @date:2019/9/23 11:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestReadWriteLock {

    public static void main(String[] args) {


        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        new Thread(() -> {
            demo.set(new SecureRandom().nextInt(100));
        }).start();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                demo.get();
            }).start();
        }

    }


}

class ReadWriteLockDemo{

    private Integer number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // read

    public void get(){
        // 加锁
        lock.readLock().lock();

        try {
            System.out.println("number :  "+this.number);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void set(Integer number) {

        lock.writeLock().lock();

        try {

            System.out.println(Thread.currentThread().getName() + " : "+number);
            this.number = number;

        }finally {
            lock.writeLock().unlock();
        }
    }
}
