package com.future_question;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * TODO
 *
 * @date:2019/10/17 19:42
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> task1 = new FutureTask<>(new Runnable() {
            @Override
            public void run() {
                System.out.println("-");
            }
        }, "aaaaaaaaaaaaa");


        executor.execute(task1);


        new Thread(new Runnable() {
            @Override
            public void run() {


            }
        });

        System.out.println("task1.get() = " + task1.get());
    }


}
