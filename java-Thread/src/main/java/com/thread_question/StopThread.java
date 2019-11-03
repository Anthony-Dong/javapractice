package com.thread_question;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 怎么停止一个进程
 *
 * 问什么取消 thread的 stop的方法  ,就是因为存在潜在的不安全性,可能 发生状态不一致的现象
 * <a>https://docs.oracle.com/javase/7/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html</>
 *
 * @date:2019/9/10 12:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread thread = new Thread() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getState());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------------");
                System.out.println("此处代码不会执行");
            }
        };
        // 启动线程
        thread.start();
//        thread.join();
        // 主线程休眠0.1秒
        System.out.println("-----------主线程");
        Thread.sleep(100);
        // 子线程停止
        System.out.println("thread.getState() = " + thread.getState());

    }


    private static void method01(){
        StopThreadClass stopThreadClass = new StopThreadClass();
        Thread thread = new Thread(stopThreadClass);


        // 开启子线程
        thread.start();

        // 子线程停止
        stopThreadClass.setStopping(true);

        // 子线程先执行
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private static class StopThreadClass implements Runnable{
       volatile   boolean  isStopping = false;


        @Override
        public void run() {
            if (!isStopping) {
                System.out.println("hhhhhhhhhhhh");
            }
        }

        public void setStopping(boolean stopping) {
            isStopping = stopping;
        }
    }

}
