package com.jvm.system_properties;

/**
 *
 *
 * @date:2019/11/1 16:17
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSystemProperties {

    public static void main(String[] args) {
        System.out.println("参数 : "+args[0]);

        System.out.println("堆内存 : "+Runtime.getRuntime().maxMemory()/1000/1000+"M");
    }
}
