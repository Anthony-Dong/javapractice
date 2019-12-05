package com.anthony.async;

import com.anthony.api.ApiLog;
import com.anthony.api.ApiResponse;
import com.anthony.api.SuccessfulResponse;
import com.anthony.exception.APIException;
import com.anthony.exception.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.*;
import java.util.function.Consumer;


/**
 * 异步的  队列 和 线程池  ,  异步需要自己实现 日志操作
 *
 * @date:2019/11/5 12:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@Slf4j
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "async", ignoreUnknownFields = true)
public class AsyncQueue<T> {

    private BlockingQueue<AsyncResponse<T>> queue;


    // 异常返回结果 :
    private static HashMap<String, Object> error = new LinkedHashMap<>();
    static {
        error.put("status", 500);

    }


    // 线程池 ,里面配置了线程池属性 .
    private Pool pool = new Pool();

    // 线程池 实现类 .
    private ThreadPoolExecutor executor;


    // async.capacity=50
    // 队列容量
    private Integer capacity = 100;


    @ToString
    @Getter
    @Setter
    private class Pool {


        // async.pool.core-size=5
        // 核心线程数
        private Integer coreSize = 10;


        // async.pool.max-size=10
        // 最大线程数
        private Integer maxSize = 15;


        //  async.pool.keepalive=300
        // 最大线存活时间 / S
        private Integer keepalive = 360;

        // async.pool.queue-size=10
        // 线程中队列容量
        private Integer queueSize = 100;
    }


    /**
     * 初始化这些配置
     */
    @PostConstruct
    public void init() {

        log.info("AsyncQueue init successful , queue-capacity : {} , pool : {}", capacity, pool);

        queue = new ArrayBlockingQueue<>(capacity);

        executor = new ThreadPoolExecutor(pool.getCoreSize(),
                pool.getMaxSize(),
                pool.getKeepalive(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(pool.getQueueSize()),
                new ThreadPoolExecutor.CallerRunsPolicy());


        // 启动一个线程一直执行下去 ,去获取队列中的任务
        new Thread(() -> {
            while (true) {
                AsyncResponse<T> response = null;
                try {
                    response = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 多线程处理
                process(response);
            }
        }).start();
    }


    /**
     * 封装 响应对象 , 需要一个结果和一个
     *
     * @param result
     * @param status
     * @return
     */
    private ApiResponse<T> setResponse(T result, HttpStatus status) {

        SuccessfulResponse<T> successfulResponse = new SuccessfulResponse<>();

        successfulResponse.setStatus(status.value());

        successfulResponse.setResult(result);

        return successfulResponse;
    }


    /**
     * 设置结果
     *
     * @param future
     * @param response
     */
    private void setResult(Future<T> future, AsyncResponse<T> response) {

        // 获取异步结果
        T res = null;
        try {
            res = future.get();
        } catch (InterruptedException e) {
            // 处理异常
            doException(response,e.getMessage());
        } catch (ExecutionException e) {
            // 处理异常
            doException(response,e.getMessage());
        }


        // 获取 defer ,
        DeferredResult<ApiResponse<T>> result = response.getDeferred();

        // 设置结果 :
        result.setResult(setResponse(res, response.getStatus()));
    }


    private void doException(AsyncResponse<T> response,String msg) {
        DeferredResult<ApiResponse<T>> result = response.getDeferred();
        error.put("result", msg);
        result.setErrorResult(error);
    }


    /**
     * 处理操作 ,这里设置锁 ,是为了防止多线程 ,之间抢资源
     *
     * @param response
     */
    private synchronized void process(AsyncResponse<T> response) {
        //  这里开辟了俩线程等于 , 因为 需要处理线程 和 执行线程, 因为 java 的  Future 等于是一个阻塞线程
        //  比如说我 take() 拿到一个任务, 我去执行 ,此时我线程处于阻塞状态 , 直到有返回结果,
        //  但是大量的线程切换不好的 . .. . .. . . . . .这里我一开始设计坏了
        executor.execute(() -> {

            Callable<T> task = response.getTask();

            // 处理任务
            Future<T> future = executor.submit(task);

            // 设置 defer 结果 :
            setResult(future, response);
        });
    }

    /**
     * 移除操作
     *
     * @return
     */
    public AsyncResponse take() {
        AsyncResponse take = null;
        try {
            //  阻塞的获取
            take = queue.take();
        } catch (InterruptedException e) {
            throw new APIException(ErrorCodeEnum.SERVICE_UNAVAILABLE);
        }
        return take;
    }


    /**
     * 添加操作
     *
     * @param response
     */
    public void put(AsyncResponse response) {
        try {
            // 阻塞的添加
            queue.put(response);
        } catch (InterruptedException e) {
            throw new APIException(ErrorCodeEnum.SERVICE_UNAVAILABLE);
        }
    }

    void println(String msg) {
        System.out.println(Thread.currentThread().getName() + " : " + msg);
    }

}
