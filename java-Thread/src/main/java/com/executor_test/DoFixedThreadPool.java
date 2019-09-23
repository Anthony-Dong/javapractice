package com.executor_test;




import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.Executors.newCachedThreadPool;
import static java.util.concurrent.Executors.newSingleThreadExecutor;

/**
 * TODO
 *
 * @date:2019/9/23 10:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoFixedThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = newCachedThreadPool();



        ExecutorService executorService1 = newSingleThreadExecutor();



        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);


        ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    }
}
