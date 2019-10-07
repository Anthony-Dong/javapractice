package com.javase.event_listener.test02;

/**
 * TODO
 *
 * @date:2019/9/29 15:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Message {

    String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
