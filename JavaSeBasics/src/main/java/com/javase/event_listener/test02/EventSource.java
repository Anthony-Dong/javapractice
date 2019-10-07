package com.javase.event_listener.test02;

/**
 * TODO
 *
 * @date:2019/9/29 15:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class EventSource {
    private ClientEventListener listener;


    public EventSource(ClientEventListener listener) {
        this.listener = listener;
    }

    public void write(){
        Message message = new Message("我是写的的消息");
        Event event = new MessageEvent(message);
        listener.doRead(event);
    }




    public void send(){
        Message message = new Message("我是发送的消息");
        Event event = new MessageEvent(message);
        listener.doWriet(event);
    }

}
