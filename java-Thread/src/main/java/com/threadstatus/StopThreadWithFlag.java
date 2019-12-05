package com.threadstatus;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/14 21:05
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class StopThreadWithFlag {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        int x = 1;
        Thread thread = new Thread(() -> {
            flag = false;
        });
        thread.start();

        while (flag) {
            System.out.println(Thread.currentThread().getName() + " : " + x++);
        }
    }
}
