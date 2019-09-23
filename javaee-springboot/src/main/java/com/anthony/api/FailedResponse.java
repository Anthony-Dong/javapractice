package com.anthony.api;

import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 成功的返回 结果  竟可能少的去创建对象 ,所以采用了 这种方式
 *
 * @date:2019/9/20 20:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class FailedResponse  extends ApiResponse{

    private static final long serialVersionUID = 3403196291188778157L;

    /**
     * http 状态码
     */
    private Integer status;
    /**
     * 错误状态码
     */
    private Integer errorCode;
    /**
     * 错误描述
     */
    private String msg;
    /**
     * 异常信息
     */
    private String exception;
    /**
     * 客户端是否展示
     */
    private Boolean isShow;
    /**
     * 当前时间戳 , 统一返回给前端去处理
     */
    private Long timeStamp;


    private FailedResponse(Integer httpStatus, Integer errorCode, String msg, String exception, Boolean isShow) {
        this.status = httpStatus;
        this.errorCode = errorCode;
        this.msg = msg;
        this.exception = exception;
        this.isShow = isShow;
        this.timeStamp = System.currentTimeMillis();
    }

    private FailedResponse(){

    }

    public static FailedResponse getInstance(Integer httpStatus, Integer errorCode, String msg, String exception, Boolean isShow){
        return new FailedResponse(httpStatus, errorCode, msg, exception, isShow);
    }

}
