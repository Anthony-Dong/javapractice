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

        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "JDK 实现的 FutureTask";
            }
        });

        MyFutureTask<Object> myTask = new MyFutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "我自己 实现的 FutureTask";
            }
        });

        executor.execute(task);
        executor.execute(myTask);


        System.out.println("task = " + task.get());
        System.out.println("myTask.get() = " + myTask.get());

        executor.shutdown();
    }
}
