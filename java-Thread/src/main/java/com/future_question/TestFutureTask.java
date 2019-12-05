package com.future_question;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/9/25 21:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestFutureTask {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> task1 = new FutureTask<>(new Runnable() {
            @Override
            public void run() {

            }
        }, "aaaaaaaaaaaaa");



        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(1);

                return Thread.currentThread().getName() + " : hello world";
            }
        });
        //  有效的解耦
        executor.execute(task);
        // 主线程
        System.out.println(Thread.currentThread().getName() + "   hello world");
        // 取消任务
        task.cancel(true);
        // 获取任务是否中断
        System.out.println(task.isCancelled());

        try {
            if (!task.isCancelled()) {
                String s = task.get(2, TimeUnit.SECONDS);
                System.out.println(s);
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // 超时关闭
            executor.shutdown();
        }
        executor.shutdown();

    }


}
