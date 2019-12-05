package com.anthony.exception;

/**
 * 异常 , 这里没有做 系统异常 全部是 RuntimeException , 可以做一个  error的异常
 *
 * @date:2019/9/20 21:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class APIException extends RuntimeException {


    private static final long serialVersionUID = 3086194441378962470L;

    /**
     * 唯一一个成员变量 是 异常枚举类 , 其他是父类继承的
     */
    private ErrorCodeEnum enumException;



    public APIException(){

    }

    /**
     * 自定义消息
     * @param message
     */
    public APIException(String message) {
        super(message);
    }


    public APIException(Throwable throwable) {
        super(throwable);
    }

    /**
     * 自定义信息
     * @param message
     * @param throwable
     */
    public APIException(String message, Throwable throwable) {
        super(message, throwable);
    }


    /**
     * 枚举类
     * @param enumException
     */
    public APIException(ErrorCodeEnum enumException) {
        this.enumException = enumException;
    }



    public ErrorCodeEnum getEnumException() {
        return enumException;
    }


    public void setEnumException(ErrorCodeEnum enumException) {
        this.enumException = enumException;
    }
}
