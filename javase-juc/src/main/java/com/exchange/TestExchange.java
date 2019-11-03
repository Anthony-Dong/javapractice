package com.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * TODO
 *
 * @date:2019/10/25 18:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestExchange {

    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            System.out.println("thread1开始");
            try {
                String exchange = exchanger.exchange("来自thread1的数据",5, TimeUnit.SECONDS);
                System.out.println("thread1接收到的数据：" + exchange);
            } catch (InterruptedException | TimeoutException e) {
                System.out.println("thread1 等不及了 , 不想交换数据");
                e.printStackTrace();
            }
            System.out.println("thread1结束");
        }, "thread1").start();

        new Thread(() -> {
            System.out.println("thread2开始");
            try {
                TimeUnit.SECONDS.sleep(10);
                String exchange = exchanger.exchange("来自thread2的数据");
                System.out.println("thread2接收到的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2结束");
        }, "thread2").start();

        new Thread(() -> {
            System.out.println("thread3开始");
            try {
                TimeUnit.SECONDS.sleep(10);
                String exchange = exchanger.exchange("来自thread3的数据");
                System.out.println("thread3接收到的数据：" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread3结束");
        }, "thread3").start();
    }
}
