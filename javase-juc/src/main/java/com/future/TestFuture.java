package com.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * TODO
 *
 * @date:2019/10/28 18:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestFuture {


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        Future<Object> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });


    }


}
