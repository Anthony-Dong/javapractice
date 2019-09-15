package com.thread_question;

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

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            if (!Thread.currentThread().isInterrupted()) {

                System.out.println("1111111111");
            }

        });

        thread.start();
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());

        thread.interrupt();
        System.out.println(thread.getState());

        System.out.println(thread.isAlive());
        thread.join();
        System.out.println(thread.getState());

        System.out.println(thread.isAlive());

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
