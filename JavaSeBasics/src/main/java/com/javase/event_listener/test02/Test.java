package com.javase.event_listener.test02;

import java.util.ArrayList;

/**
 * TODO
 *
 * @date:2019/9/29 15:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Test {

    public static void main(String[] args) {

        AbstractClientEventListener eventListener = new AbstractClientEventListener(new ArrayList<Message>());

        // 添加监听器
        EventSource eventSource = new EventSource(new ClientEventListener() {
            @Override
            public void doWriet(Event event) {
                System.out.println(event.get());
            }

            @Override
            public void doRead(Event event) {
                System.out.println(event.get());
            }
        });

        eventSource.send();

        eventSource.write();


//        System.out.println("eventListener.getMessages() = " + eventListener.getMessages().get(0));
    }


}
