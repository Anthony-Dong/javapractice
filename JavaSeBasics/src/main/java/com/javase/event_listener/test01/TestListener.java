package com.javase.event_listener.test01;

public class TestListener {
    
    public static void main(String[] args) {
        EventSource person=new EventSource(new MyEventListener());

        person.run();
        person.eat();
    }
}

//实现监听器接口中的方法
class MyEventListener implements EventListener{


    @Override
    public void dorun(Event event) {
        EventSource eventSource = event.getEventSource();
        System.out.println("人在跑");
    }

    @Override
    public void doeat(Event even) {
        System.out.println("人在吃");
    }
}