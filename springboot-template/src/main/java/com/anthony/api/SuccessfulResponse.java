package com.anthony.api;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 成功的返回 结果
 *
 * @date:2019/9/20 20:11
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

@EqualsAndHashCode(callSuper = false)
@Data
public class SuccessfulResponse<T>  extends ApiResponse<T>{

    private static final long serialVersionUID = 7439533875233989488L;

    /**
     * http 状态码
     */
    private Integer status;

    /**
     * 结果集返回
     */
    private T result;


    public SuccessfulResponse(Integer status, T result) {
        this.status = status;
        this.result = result;
    }

    public SuccessfulResponse() {

    }
}
