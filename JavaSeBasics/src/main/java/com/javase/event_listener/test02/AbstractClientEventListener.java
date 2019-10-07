package com.javase.event_listener.test02;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @date:2019/9/29 15:24
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class AbstractClientEventListener implements  ClientEventListener {

    private List<Message> messages;


    public AbstractClientEventListener(List<Message> messages) {
        this.messages = messages;
    }


    public List<Message> getMessages() {
        return messages;
    }


    @Override
    public void doWriet(Event event) {
        Message message = event.get();
        messages.add(message);
    }

    @Override
    public void doRead(Event event) {
        messages.remove(event.get());
    }
}
