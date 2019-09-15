package com.thread_question;

/**
 * TODO
 *
 * @date:2019/9/11 18:51
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ThreadGroupQuestion {


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("-----------------");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("-----------------");
        }, "t2");
        Thread t3 = new Thread(() -> {
            System.out.println("-----------------");
        }, "t3");


        t1.start();
        t2.start();
        t3.start();

        Thread main = Thread.currentThread();

//        System.out.println("thread.getName() = " + main.getName());


        ThreadGroup threadGroup = main.getThreadGroup();



        Thread[] threads = new Thread[threadGroup.activeCount()];

        threadGroup.enumerate(threads, true);

        System.out.println("count"+threadGroup.activeCount());

        for (Thread thread : threads) {
            try {
                System.out.println(thread.getName());
//                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                System.out.println("thread.getState() = " + thread.getState());
            }
        }

    }

}
