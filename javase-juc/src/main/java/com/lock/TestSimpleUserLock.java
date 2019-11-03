package com.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @date:2019/10/28 20:02
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSimpleUserLock {
    private static final Lock LOCK = new ReentrantLock();

    private static ExecutorService service = Executors.newFixedThreadPool(10);



    public static void main(String[] args) {

//        service.execute(TestSimpleUserLock::doInterruptibleLock);
//        service.execute(TestSimpleUserLock::doInterruptibleLock);
//        service.execute(TestSimpleUserLock::doInterruptibleLock);

//        service.execute(TestSimpleUserLock::doLock);
//        service.execute(TestSimpleUserLock::doLock);
//        service.execute(TestSimpleUserLock::doLock);


//        service.execute(TestSimpleUserLock::doTryLock);
//        service.execute(TestSimpleUserLock::doTryLock);
//        service.execute(TestSimpleUserLock::doTryLock);
        service.execute(TestSimpleUserLock::doTryLock);
        service.execute(TestSimpleUserLock::doTryLock);
        service.execute(TestSimpleUserLock::doTryLock);



    }

    static void doLock() {
        LOCK.lock();
        try {
            System.out.println("我执行了 : "+Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前线程 : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException("sleep InterruptedException in "+Thread.currentThread().getName());
        } finally {
            LOCK.unlock();
        }
    }



    static void doInterruptibleLock() {
        try {
            LOCK.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException("InterruptedException in "+Thread.currentThread().getName());
        }
        try {
            System.out.println("我执行了 : "+Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前线程 : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException("sleep Exception in "+Thread.currentThread().getName());
        } finally {
            LOCK.unlock();
        }
    }



    static void doTryLock() {
        if (LOCK.tryLock()) {
            try {
                System.out.println("我执行了 : " + Thread.currentThread().getName());
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("当前线程 : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                LOCK.unlock();
            }
        } else {
            System.out.println("没拿到锁,我很慌, "+Thread.currentThread().getName());
        /*    try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            doTryLock();
        }
    }


    static void doTryLockWithTimeOut()  {

        try {
            if (LOCK.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    System.out.println("我执行了 : " + Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("当前线程 : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException("sleep Exception in " + Thread.currentThread().getName());
                } finally {
                    LOCK.unlock();
                }
            } else {
              System.out.println("没拿到锁,我很慌, "+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static void doUNLock() {

        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("当前线程 : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("======sleep interrupted======" + Thread.currentThread().getName());
        }
    }
}

 /*       try {
            LOCK.lock();
        } catch (InterruptedException e) {
            System.out.println("======被打断了======");
        }

      try {
            LOCK.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("======超时了======"+ Thread.currentThread().getName());
        }*/