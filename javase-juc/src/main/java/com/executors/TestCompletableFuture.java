package com.executors;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * TODO
 *
 * @date:2019/12/1 22:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestCompletableFuture {


    public static void main(String[] args) {


        CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).thenRun(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void aVoid, Throwable throwable) {

            }
        }).join();


        CompletableFuture<Object> future = new CompletableFuture<>();





        System.out.println("主线程");

    }


}
