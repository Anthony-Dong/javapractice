package com.executor_test;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/10/27 17:39
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 240, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024),
                new ThreadPoolExecutor.CallerRunsPolicy());

        // 我一种 方式
        executor.execute(()->{
            System.out.println("new  runnable");
        });

        // 第二种 方式
        Future<String> over = executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "over");
        // 这个方法会阻塞




        // submit 方法
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                return "HELLO WORLD , Future";
            }
        });

        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return  "HELLO WORLD , FutureTask";
            }
        });

        // execute 方法
        executor.execute(task);


        System.out.println("task.get() = " + task.get());

        System.out.println("future.get() = " + future.get());

        System.out.println("over.get() = " + over.get());

        executor.shutdown();

    }
}
