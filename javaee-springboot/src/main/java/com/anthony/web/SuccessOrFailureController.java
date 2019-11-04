package com.anthony.web;

import com.anthony.api.ApiLog;
import com.anthony.api.ApiResponse;
import com.anthony.core.BasicController;

import com.anthony.exception.APIException;
import com.anthony.exception.ErrorCodeEnum;
import org.springframework.web.bind.annotation.*;

/**
 *  SuccessOrFailureController
 *
 * @date:2019/9/20 20:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


@RestController
public class SuccessOrFailureController extends BasicController {

    @ApiLog
    @GetMapping("/success")
    public ApiResponse<Integer> doSuccess(){
        return success(66666);
    }

    @ApiLog
    @GetMapping("/failure")
    public ApiResponse<Integer> failure(){
        int x = 1 / 0;
        return success(66666);
    }
}
