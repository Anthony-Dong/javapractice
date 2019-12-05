package com.threadstatus;

/**
 * TODO
 *
 * @date:2019/11/14 21:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class StopThreadByException {


    public static void main(String[] args) {
        new Thread(() -> {
            int x = 1;
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + x++);
                if (x == 5) {
                    // 抛出异常
                    throw new RuntimeException("exception");
                }
            }
        }).start();
    }
}
