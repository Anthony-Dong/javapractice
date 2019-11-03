package com.semaphore;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @date:2019/10/25 18:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestLock {

    public static void main(String[] args) {

        final ReentrantLock lock = new ReentrantLock();

        System.out.println("--------ReentrantLock-----------");

        IntStream.range(0, 4).forEach(e->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "  开始");
                lock.lock(); // 一次拿一把锁
                try {
                    System.out.println(Thread.currentThread().getName() + "  拿到锁");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "  等待完毕");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + "  释放锁");
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "  结束");
            }, "thread" + (e + 1)
            ).start();
        });


        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "  开始");
            // 一次拿一把锁
            try {
                System.out.println(Thread.currentThread().getName() + "  拿到锁");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "  等待完毕");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "  释放锁");

            }
            System.out.println(Thread.currentThread().getName() + "  结束");
        }, "thread" + 5
        ).start();
    }


}
