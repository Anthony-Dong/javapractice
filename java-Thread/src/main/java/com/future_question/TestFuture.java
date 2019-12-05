package com.future_question;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/9/25 21:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestFuture {


    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return Thread.currentThread().getName() + "   hello world";
            }
        });


        System.out.println(Thread.currentThread().getName() + "   hello world");


        try {
            String s = future.get(2, TimeUnit.SECONDS);
            System.out.println(s);
            // 判断是否任务执行完
            System.out.println("isDone : "+future.isDone());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            // 超时关闭
            executor.shutdown();
        }
        // 正确关闭
        executor.shutdown();
    }

}
