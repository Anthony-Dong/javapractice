package com.javase.design_pattern.singleno;

/**
 * TODO
 *
 * @date:2019/9/21 10:23
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoubleCheckSingleton {

    // 保证可见性
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton(){

    }

    public static DoubleCheckSingleton getInstance(){

        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }

        return instance;
    }

}
