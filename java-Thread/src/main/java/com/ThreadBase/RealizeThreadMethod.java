package com.ThreadBase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName:RealizeThreadMethod
 * Package:com.ThreadBase
 * Description:
 *
 * @date:2019/8/1 22:35
 * @author: 574986060@qq.com
 */

public class RealizeThreadMethod {

    public static class ThreadOne extends Thread {

        @Override
        public void run() {

                System.out.println("running");
        }
    }

    public static class ThreadTwo implements Runnable{
        private  static int num = 2;
        @Override
        public void run() {
            if (num > 0) {
                num--;
                System.out.println(num);
            }
        }
    }


    public static class ThreadThree implements Callable<String> {


        @Override
        public String call() throws Exception {
            return "running";
        }
    }


    public static void main(String[] args) {


//        ThreadOne thread = new ThreadOne();         // 创建线程
//        thread.start();                             // 启动线程



/*        ThreadTwo threadTwo = new ThreadTwo();
        new Thread(threadTwo).start();
        new Thread(threadTwo).start();
        new Thread(threadTwo).start();
        new Thread(threadTwo).start();*/


        FutureTask<String> task = new FutureTask<>(new ThreadThree());

        new Thread(task).start();
        try {
            String s = task.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }





}
