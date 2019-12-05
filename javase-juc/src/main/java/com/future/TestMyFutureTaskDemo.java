package com.future;

import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/10/6 23:37
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestMyFutureTaskDemo {


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        long start = System.currentTimeMillis();

        MyFutureTask<Object> myTask = new MyFutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                TimeUnit.MILLISECONDS.sleep(3000);
                return Thread.currentThread().getName();
            }
        });

        executor.execute(myTask);

        MyFutureTask<Object> myTask2 = new MyFutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                TimeUnit.MILLISECONDS.sleep(3000);
                return Thread.currentThread().getName();
            }
        });

        executor.execute(myTask2);


        System.out.println(myTask.get());
        System.out.println(myTask2.get());

        System.out.println(System.currentTimeMillis() - start);

        executor.shutdown();
    }
}
