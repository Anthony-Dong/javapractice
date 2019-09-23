package com.anthony.exception;

/**
 * TODO
 *
 * @date:2019/9/20 21:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyException extends RuntimeException {


    private static final long serialVersionUID = 3086194441378962470L;


    public MyException(){

    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String message, Throwable throwable) {
        super(message, throwable);
    }


    private ErrorCodeEnum enumException;

    public MyException(ErrorCodeEnum enumException) {
        this.enumException = enumException;
    }

    public ErrorCodeEnum getEnumException() {
        return enumException;
    }

    public void setEnumException(ErrorCodeEnum enumException) {
        this.enumException = enumException;
    }
}
