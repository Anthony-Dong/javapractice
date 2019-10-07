package com.javase.event_listener.test01;

/**
 * TODO
 *
 * @date:2019/9/29 15:10
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Event {

    private EventSource eventSource;

    public Event(EventSource eventSource) {
        super();
        this.eventSource = eventSource;
    }

    public EventSource getEventSource() {
        return eventSource;
    }

    public void setEventSource(EventSource eventSource) {
        this.eventSource = eventSource;
    }
}
