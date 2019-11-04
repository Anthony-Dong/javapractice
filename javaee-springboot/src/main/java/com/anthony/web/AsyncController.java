package com.anthony.web;


import com.anthony.api.ApiResponse;
import com.anthony.core.BasicController;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *  AsyncController ,  异步的方式 ,
 *
 * @date:2019/9/20 20:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


@RestController
@EnableScheduling
public class AsyncController {
    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(10);

    private final Random random = new Random();


    /**
     * 启动一个定时任务 , 定时去解决请求 . , 可以new 其他线程 ,之类的 ,用post constructor 也可以
     */
    @Scheduled(fixedRate = 5000)
    public void process() {
        DeferredResult<String> result = null;
        do {
            try {
                result = queue.take();
                long timeout = random.nextInt(70);
                Thread.sleep(timeout);


                result.setResult("hello world" + "耗时 : " + timeout + "ms");

                println("执行计算结果,耗时 : " + timeout + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (result != null);
    }


    /**
     * 异步通知 , 这里 不能使用 BasicController ,需要加工
     * @return
     */
    @GetMapping("/async")
    public DeferredResult<String> get() {

        DeferredResult<String> result = new DeferredResult<>(50L);
        queue.offer(result);

        println("开始");

        result.onCompletion(() -> {
            println("完成");
        });

        result.onTimeout(() -> {
            println("超时");
        });
        return result;
    }


    void println(String msg) {
        System.out.println(Thread.currentThread().getName() + " : " + msg);
    }
}