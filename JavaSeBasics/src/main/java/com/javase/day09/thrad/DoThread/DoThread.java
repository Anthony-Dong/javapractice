package com.javase.day09.thrad.DoThread;

import jdk.nashorn.internal.ir.Flags;
import sun.security.krb5.internal.Ticket;

/**
 * ClassName:Dothread
 * Package:com.javase.day09.thrad.DoThread
 * Description:
 *
 * @date:2019/7/21 11:37
 * @author: 574986060@qq.com
 */

public class DoThread implements Runnable {
    private static Integer ticket = 10;

    @Override
    public synchronized void run() {
        while (isRun(ticket)) {
            System.out.println(Thread.currentThread().getName() + ":" + (ticket--));
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method"+Thread.interrupted());
        }
    }
     public Boolean isRun(Integer ticket) {
        return ticket > 0 ? true : false;
    }

    public static void main(String[] args) {
        DoThread doThread = new DoThread();
        DoThread doThread2 = new DoThread();
        Thread thread = new Thread(doThread, "小明");
        thread.start();
        Thread thread1 = new Thread(doThread2, "小王");
        thread1.start();
        System.out.println("SocketIO:"+thread.isInterrupted());
        System.out.println("thread1:"+thread1.isInterrupted());
    }
}
