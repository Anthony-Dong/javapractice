package com.javase.exception;

/**
 * TODO
 *
 * @date:2019/11/14 22:34
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MyException(String message) {
        super(message);
    }
}
