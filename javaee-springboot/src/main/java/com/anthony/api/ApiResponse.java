package com.anthony.api;

import org.springframework.http.HttpStatus;


import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 请求api
 *
 * @date:2019/9/20 20:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ApiResponse<T>  implements Serializable {


    private static final long serialVersionUID = -2860707383351020390L;

    /**
     *  成功返回 状态码 + 返回结果
     * @param response
     * @param status
     * @param result
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(HttpServletResponse response, HttpStatus status, T result) {

        response.setStatus(status.value());
        return new SuccessfulResponse<>(status.value(), result);
    }


    /**
     * 无返回结果的 有状态码
     * @param response
     * @param status
     * @return
     */
    public static  ApiResponse<Void> success(HttpServletResponse response, HttpStatus status){
        response.setStatus(status.value());
        return success(response, status, null);
    }



    /**
     * 有返回结果的  状态码 是 200
     *
     *
     *
     * @param response
     * @param object
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(HttpServletResponse response, T object) {
        return success(response, HttpStatus.OK, object);
    }


    /**
     * 失败
     * @param status
     * @param errorCode
     * @param msg
     * @param exception
     * @param isShow
     * @return
     */
    public static ApiResponse failed(Integer status, Integer errorCode, String msg, String exception, Boolean isShow){
        return new FailedResponse(status, errorCode, msg, exception, isShow);
    }

}
