package com;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/13 22:24
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class stop_thread {


    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + "执行了一次");

                // 1. 给当前线程一个 打断标志 ,需要用户去选择
                Thread.currentThread().interrupt();

                // 2. 判断当前线程是被打断 , 此时线程还处于运行中
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " 的线程状态 : " + Thread.currentThread().getState());
                    // 我们break 结束线程
                    break;
                }
            }
        }).start();

    }


}
