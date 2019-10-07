package com.javase.event_listener.test02;

/**
 * TODO
 *
 * @date:2019/9/29 15:28
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MessageEvent implements Event {

    private Message message;


    public MessageEvent(Message message) {
        this.message = message;
    }

    @Override
    public Message get() {
        return this.message;
    }
}
