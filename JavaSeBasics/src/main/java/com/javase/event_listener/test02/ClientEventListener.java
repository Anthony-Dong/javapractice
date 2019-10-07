package com.javase.event_listener.test02;


import java.util.EventListener;

/**
 * TODO
 *
 * @date:2019/9/29 15:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface ClientEventListener  extends EventListener {


    void doWriet(Event event);


    void doRead(Event event);

}
