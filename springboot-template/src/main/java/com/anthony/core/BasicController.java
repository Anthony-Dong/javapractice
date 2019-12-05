package com.anthony.core;

import com.anthony.api.*;
import com.anthony.async.AsyncQueue;
import com.anthony.async.AsyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.concurrent.Callable;
import java.util.function.Consumer;


/**
 * @date:2019/9/20 20:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class BasicController {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;


    /**
     * 直接返回200,无返回结果
     *
     * @return
     */
    public ApiResponse<Void> success() {
        return ApiResponse.success(response, HttpStatus.OK);
    }


    /**
     * 成功返回
     * 状态码 200
     * 带返回结果
     *
     * @param result
     * @param <T>
     * @return
     */
    public <T> ApiResponse<T> success(T result) {
        return ApiResponse.<T>success(response, result);
    }

    /**
     * 只带有状态码的
     *
     * @param status
     * @return
     */
    public ApiResponse<Void> success(HttpStatus status) {
        return ApiResponse.<Void>success(response, status);
    }

    /**
     * 自定义状态码 和 返回结果的
     *
     * @param status
     * @param result
     * @param <T>
     * @return
     */
    public <T> ApiResponse<T> success(HttpStatus status, T result) {
        return ApiResponse.<T>success(response, status, result);
    }

    public <T> ApiResponse<ApiPage<T>> success(ApiPage<T> result) {
        return ApiResponse.<ApiPage<T>>success(response, result);
    }





    public <T> DeferredResult<ApiResponse<T>> async(HttpStatus status,Callable<T> result) {
        return async(status, result, null, null);
    }



    public <T> DeferredResult<ApiResponse<T>> async(HttpStatus status,Callable<T> result, Long timeout) {
        return async(status, result, timeout, null);
    }



    /**
     * 不需要携带状态码 , 默认是 200
     *
     *  设置超时时间
     * @param result
     * @param <T>
     * @return
     */
    public <T> DeferredResult<ApiResponse<T>> async(Callable<T> result, Long timeout) {

        return async(HttpStatus.OK, result, timeout, null);
    }




    /**
     * 不需要携带状态码 , 默认是 200
     * @param result
     * @param <T>
     * @return
     */
    public <T> DeferredResult<ApiResponse<T>> async(Callable<T> result) {
        return async(HttpStatus.OK, result, null, null);
    }


    @Autowired
    private  AsyncQueue<? extends AsyncResponse> queue;


    /**
     * 需要携带状态码
     *
     * @param status
     * @param task
     * @param <T>
     * @return
     */
    public <T> DeferredResult<ApiResponse<T>> async(HttpStatus status, Callable<T> task, Long timeout, String error) {

        DeferredResult<ApiResponse<T>> result = null;


        if (null == timeout) {
            // 设置一个 DeferredResult
            result = new DeferredResult<>();
        }else{

            if (null == error) {
                // 设置一个 DeferredResult
                result = new DeferredResult<>(timeout);
            } else {

                // 设置一个错误的返回信息
                FailedResponse response = new FailedResponse();
                response.setErrorCode(500);
                response.setMsg(error);
                //
                result = new DeferredResult<>(timeout,response);
            }
        }


        // 封装响应对象
        AsyncResponse<T> response = new AsyncResponse<>();
        response.setStatus(status);
        response.setTask(task);
        response.setDeferred(result);


        result.onCompletion(() -> {
            println("async  : 完成");
        });


        result.onTimeout(() -> {
            println("async  : 超时");
        });


        result.onError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                System.out.println("----------------------");
            }
        });

        //  添加对象
        queue.put(response);

        // 返回对象
        return result;
    }


    void println(String msg) {
        System.out.println(Thread.currentThread().getName() + " : " + msg);
    }

}
