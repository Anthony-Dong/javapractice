package com.javase.design_pattern.listener_design_pattern;



/**
 *
 *
 * @date:2019/11/9 14:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestEventListener implements CoreEventListener<CoreEventObject> {
    private CoreEventObject object;

    /**
     * 当 X = 0 ,代表 obj还没有初始化了
     * 当 x = 1 , 代表 obj 以及初始化了 , 已经接收到了
     */
    private static volatile int x = 0;


    @Override
    public void onEventObject(CoreEventObject object) {
        this.object = object;
        // 收到改成 1
        x = 1;
    }

    public CoreEventObject getObject() {
        while (true) {
            if (x == 1) {
                break;
            }
        }
        // 拿到对象,再设置为1
        x = 0;
        return object;
    }
}
