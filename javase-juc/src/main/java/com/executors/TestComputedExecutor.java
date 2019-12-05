package com.executors;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/12/1 22:02
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestComputedExecutor {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ExecutorCompletionService completionService = new ExecutorCompletionService(executorService);


        long start = System.currentTimeMillis();
        completionService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return   Thread.currentThread().getName();
        });
        completionService.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            return   Thread.currentThread().getName();
        });
        completionService.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return   Thread.currentThread().getName();
        });

        int count = 0;

        while (count < 3) {
            Future poll = completionService.poll();
            if (poll != null) {
                count++;
                System.out.println("poll.get() = " + poll.get());
            }
        }
        executorService.shutdown();
        System.out.println(System.currentTimeMillis() - start);
    }
}
