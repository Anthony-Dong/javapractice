package com.future_question;

import java.util.EventListener;
import java.util.EventObject;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @date:2019/10/6 23:37
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class CallbackCustomizer {



    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println("我自己实现的  task future ");


        MyFutureTask<String> task = new MyFutureTask<String>(new Callable() {
            @Override
            public Object call() throws Exception {
                return "" + Thread.currentThread().getName();
        }
        });
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("我自己实现的 get 结果 = " + task.get());



        System.out.println("JUC 实现的  task future ");

        FutureTask<String> task1 = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "" + Thread.currentThread().getName();
            }
        });
        new Thread(task1).start();
        System.out.println("JUC 实现的 get : "+task1.get());
    }




}
