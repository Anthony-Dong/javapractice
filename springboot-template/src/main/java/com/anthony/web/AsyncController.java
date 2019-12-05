package com.anthony.web;


import com.anthony.api.ApiLog;
import com.anthony.api.ApiResponse;
import com.anthony.core.BasicController;
import com.anthony.exception.APIException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;


/**
 *  这个是基于 DeferredResult 的一种异步编程思想
 *
 * @date:2019/9/20 20:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


@RestController
@EnableScheduling
public class AsyncController extends BasicController{
    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(10);
    private final Random random = new Random();


    /**
     * 启动一个定时任务 , 定时去解决请求 . , 可以new 其他线程 ,之类的 ,用post constructor 也可以
     */
    @Scheduled(fixedRate = 500)
    public void process() {
        DeferredResult<String> result = null;
        do {
            println("任务执行 : "+ System.currentTimeMillis());
            try {
                // 没有任务就阻塞了  // /  / /
                result = queue.take();
                result.setResult(echo("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (result != null);
    }


    /**
     * 简单体验一下  DeferredResult
     * @return
     */
    @GetMapping("/async/test")
    public DeferredResult<String> async() {

        DeferredResult<String> result = new DeferredResult<>();
        try {
            // put 如果队列不够大 , 直接阻塞
            queue.put(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("AsyncController 接收到一个异步请求");

        result.onCompletion(() -> {
            println("完成");
        });

        result.onTimeout(() -> {
            println("超时");
        });
        return result;
    }


    /**
     * spring的异步 方式
     * @param id
     * @return
     */
    @GetMapping("/async/spring/{id}")
    public Callable<String> springAsync(@PathVariable("id")String id) {
        println("AsyncController 接收到一个异步请求");
        return () -> echo(id);
    }


    /**
     * 自己实现的方式
     * @param id
     * @return
     */
    @ApiLog
    @GetMapping("/async/me/{id}")
    public DeferredResult<ApiResponse<String>> meAsync(@PathVariable("id")String id) {
        println("AsyncController 接收到一个异步请求");
        return async(() -> echo(id));
    }


    /**
     * 传统方式 方式
     * @param id
     * @return
     */
    @GetMapping("/async/general/{id}")
    public String general(@PathVariable("id")String id) {
        println("AsyncController 接收到一个异步请求");
        return echo(id);
    }


    /**
     * 模拟Service  延迟请求
     * @param name
     * @return
     */
    public String echo(String name){
        long start=0;
        try {
            // 模拟消耗时间
            start = System.currentTimeMillis();
            Thread.sleep(random.nextInt(3000));
            int i = random.nextInt(2);

//            if (i == 1) {
               int x = 1 / 0;
//            }

        } catch (InterruptedException e) {
            throw new APIException();
        }
        return "收到信息 : " + name + " , 消耗时间 : " + (System.currentTimeMillis() - start) + " 执行线程: " + Thread.currentThread().getName();
    }


    /**
     * print
     * @param msg
     */
    void println(String msg) {
        System.out.println(Thread.currentThread().getName() + " : " + msg);
    }

}