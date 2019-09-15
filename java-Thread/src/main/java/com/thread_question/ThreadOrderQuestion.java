package com.thread_question;

import java.util.concurrent.locks.LockSupport;

/**
 * 怎么 顺序的启动一个线程
 *
 * @date:2019/9/10 12:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ThreadOrderQuestion {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ThreadOrderQuestion::RunClass, "111111");
        Thread thread2 = new Thread(ThreadOrderQuestion::RunClass, "222222");
        Thread thread3 = new Thread(ThreadOrderQuestion::RunClass, "333333");


        waitAndOrderThread(thread1);

        waitAndOrderThread(thread2);
        waitAndOrderThread(thread3);
    }


    public static void waitAndOrderThread(Thread thread) {

        if (thread.getState().equals(Thread.State.NEW)) {

            thread.start();

        }

        while (thread.isAlive()) {

            synchronized (thread){
                try {
                    thread.wait();    //这个会发生阻塞加锁,等待自动释放锁 ,不用自己掉用notify
//                    thread.notify();

//                    LockSupport.park();  //这个会发生死锁
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }



    }



    public static void test() throws InterruptedException {
        Thread thread1 = new Thread(()->{
            ThreadOrderQuestion.RunClass();}, "11111111111");

        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(()->{RunClass();}, "222222");

        thread2.start();
        thread2.join();
        Thread thread3 = new Thread(ThreadOrderQuestion::RunClass, "333333");

        thread3.start();
        thread3.join();

    }
    private static void RunClass() {
        System.out.println(Thread.currentThread().getName());
    }




}
