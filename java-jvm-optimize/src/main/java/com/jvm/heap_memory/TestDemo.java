package com.jvm.heap_memory;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/2 17:02
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDemo {
    public static void main(String[] args) {

        try {
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
