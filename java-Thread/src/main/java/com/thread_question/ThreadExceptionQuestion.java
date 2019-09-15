package com.thread_question;

import java.time.temporal.Temporal;

/**
 * 关于线程异常的问题
 *
 * @date:2019/9/10 14:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ThreadExceptionQuestion {


    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler((thread,throwable)->{
            System.out.println(thread.getName()+"---"+throwable.getMessage());
        });

        Thread yichang = new Thread(new Runnable() {
            @Override
            public void run() {

                throw new RuntimeException("我的异常");

            }
        });
        yichang.start();
        System.out.println(yichang.isAlive());
        try {
            yichang.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(yichang.isAlive());
    }



}
