package com.javase.design_pattern.listener_design_pattern;



import java.util.EventListener;


/**
 * TODO
 *
 * @date:2019/11/9 13:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@FunctionalInterface
public interface CoreEventListener<E extends CoreEventObject> extends EventListener {

    void onEventObject(E event);

}
