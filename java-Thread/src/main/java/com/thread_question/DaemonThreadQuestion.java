package com.thread_question;

/**
 * 守护线程  当主线程退出时,守护线程会执行完毕吗 ,全看机器性能
 *
 * @date:2019/9/11 17:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DaemonThreadQuestion {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("1111111");
        });

        thread.setDaemon(true);

        thread.start();

//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
