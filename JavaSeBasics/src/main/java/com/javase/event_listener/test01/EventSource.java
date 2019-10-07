package com.javase.event_listener.test01;

/**
 *
 *
 * @date:2019/9/29 15:07
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class EventSource {

    private EventListener eventListener;

    public EventSource(EventListener eventListener) {
        this.eventListener = eventListener;
    }


    public void run(){
        if(eventListener!=null){
            Event even=new Event(this);
            this.eventListener.dorun(even);
        }
        System.out.println("人具有跑的方法");
    }

    public void eat(){
        if(eventListener!=null){
            Event even=new Event(this);
            this.eventListener.doeat(even);
        }
        System.out.println("人具有吃的方法");
    }

}
