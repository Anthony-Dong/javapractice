package com.anthony.core;

import com.anthony.api.ApiResponse;
import com.anthony.api.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
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
     * @return
     */
    public ApiResponse<Void> success(){
        return ApiResponse.success(response, HttpStatus.OK);
    }


    /**
     *  成功返回
     *  状态码 200
     *  带返回结果
     * @param result
     * @param <T>
     * @return
     */
    public <T> ApiResponse <T> success(T result){
        return ApiResponse.<T>success(response,result);
    }

    /**
     * 只带有状态码的
     * @param status
     * @return
     */
    public  ApiResponse<Void> success(HttpStatus status){
        return ApiResponse.<Void>success(response, status);
    }

    /**
     * 自定义状态码 和 返回结果的
     * @param status
     * @param result
     * @param <T>
     * @return
     */
    public <T> ApiResponse<T> success(HttpStatus status, T result) {
        return ApiResponse.<T>success(response, status, result);
    }

    public <T> ApiResponse<Page<T>> success(Page<T> result){

        return ApiResponse.<Page<T>>success(response, result);
    }
}
