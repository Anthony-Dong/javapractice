package com.future_question;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/12/1 14:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        long start = System.currentTimeMillis();
        Future<String> submit1 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(3000);
                return Thread.currentThread().getName() + " : 执行";
            }
        });

        Future<String> submit2 = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(3000);
                return Thread.currentThread().getName() + " : 执行";
            }
        });
        submit1.get();
        submit2.get();

        System.out.println("花费时间 : "+(System.currentTimeMillis()-start));

    }


}
