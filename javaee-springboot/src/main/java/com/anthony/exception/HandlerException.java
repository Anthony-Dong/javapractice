package com.anthony.exception;

import com.anthony.api.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO
 *
 * @date:2019/9/20 23:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(MyException.class)
    public @ResponseBody ApiResponse handler(MyException e) {

        if (null==e.getEnumException()) {
            return ApiResponse.failed(500,
                    500,
                    e.toString(),
                    e.toString(),
                    true);
        }
        ApiResponse failed = ApiResponse.failed(e.getEnumException().getHttpCode(),
                e.getEnumException().getHttpCode(),
                e.getEnumException().getMsg(),
                e.getLocalizedMessage(),
                e.getEnumException().isShow());

        System.out.println(failed.hashCode());

        return failed;
    }
}
