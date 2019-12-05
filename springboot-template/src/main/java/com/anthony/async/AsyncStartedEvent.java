package com.anthony.async;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
/**
 *
 *
 * @date:2019/11/4 21:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class AsyncStartedEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("=========所有应用启动成功==========");
    }
}
