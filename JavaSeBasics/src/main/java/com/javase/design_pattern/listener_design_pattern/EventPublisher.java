package com.javase.design_pattern.listener_design_pattern;

/**
 * TODO
 *
 * @date:2019/11/9 14:04
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class EventPublisher<E extends CoreEventObject> {

    private CoreEventListener<E> listener;


    public EventPublisher(CoreEventListener<E> listener) {
        this.listener = listener;
    }


    public void publish(E object){
        System.out.println("发布事件 : " + object);
        listener.onEventObject(object);
    }
}
