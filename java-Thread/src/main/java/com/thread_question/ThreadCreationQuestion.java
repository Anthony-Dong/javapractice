package com.thread_question;

/**
 * 创建线程
 *
 * @date:2019/9/10 12:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ThreadCreationQuestion {


    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("start");
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName());
    }


    private static class DoRunnable implements Runnable {
        @Override
        public void run() {

        }
    }

}
