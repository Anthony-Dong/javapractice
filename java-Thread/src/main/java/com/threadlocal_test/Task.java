package com.threadlocal_test;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // 执行
        new Thread(new Task(),"线程一").start();
        // 不执行
        new Thread(Task::new,"线程二").start();
    }
}