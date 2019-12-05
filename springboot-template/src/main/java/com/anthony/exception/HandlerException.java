package com.anthony.exception;

import com.anthony.api.ApiResponse;
import com.anthony.core.BasicController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理类 : BasicController 只会对 这个 类进行 切面通知
 *
 * @date:2019/9/20 23:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@ControllerAdvice(assignableTypes = {BasicController.class})
public class HandlerException {


    /**
     * 注入 异常 , 失败 . 设置 响应的返回状态码 . 让前端ajax 可以抓住异常
     */
    @Autowired
    private HttpServletResponse response;

    @ExceptionHandler(APIException.class)
    public @ResponseBody ApiResponse handler(APIException e) {

        /**
         * 没有枚举 , 那么就默认异常  ,
         */
        if (null==e.getEnumException()) {
            response.setStatus(500);
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

        response.setStatus(e.getEnumException().getHttpCode());
        return failed;
    }
}
