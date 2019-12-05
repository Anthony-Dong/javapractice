package com.anthony.async;

import com.anthony.api.ApiResponse;
import com.anthony.api.SuccessfulResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 *
 *
 * @date:2019/11/4 21:08
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@ToString
@Setter
@Getter
public class AsyncResponse<T> extends ApiResponse<T> {

    // 结果
    private DeferredResult<ApiResponse<T>> deferred;

    // 任务
    private Callable<T> task;

    // 状态码
    private HttpStatus status;
}
