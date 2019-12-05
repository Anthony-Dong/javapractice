package com.javase.design_pattern.listener_design_pattern;

import java.util.EventObject;

/**
 *
 *
 * @date:2019/11/9 13:57
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class CoreEventObject extends EventObject {



    public CoreEventObject(EventSource source) {
        super(source);
    }


}
