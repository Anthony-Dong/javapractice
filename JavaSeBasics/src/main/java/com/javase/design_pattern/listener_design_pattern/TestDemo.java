package com.javase.design_pattern.listener_design_pattern;

/**
 * TODO
 *
 * @date:2019/11/9 14:05
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDemo {


    public static void main(String[] args) {

        EventPublisher<CoreEventObject> publisher = new EventPublisher<>(new CoreEventListener<CoreEventObject>() {
            @Override
            public void onEventObject(CoreEventObject event) {

                Object source = event.getSource();

                if (((EventSource) source).isSuccess()) {
                    System.out.println("======================");
                }

            }
        });

        publisher.publish(getCoreEventObject());
        publisher.publish(getCoreEventObject());
        publisher.publish(getCoreEventObject());
    }


    private static CoreEventObject getCoreEventObject() {

        EventSource eventSource = new EventSource() {
            @Override
            public boolean isSuccess() {
                return true;
            }
        };
        return new CoreEventObject(eventSource);
    }

}
