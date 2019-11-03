package com.jvm.heap_memory;

/**
 * TODO
 *
 * @date:2019/11/2 14:50
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class HeapAlloc {


    public static void main(String[] args) {
        System.out.println("======================================");

        System.out.println("初始化");
        System.out.println("最大堆空间 : "+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆空间 : "+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("初始化堆空间 : "+Runtime.getRuntime().totalMemory()/1024/1024+"M");

        System.out.println("======================================");

        // byte  是 一个字节 , 所以是 10M
        byte[] b = new byte[2 * 1024 * 1024];
        System.out.println("分配2M的内存空间");
        System.out.println("最大堆空间 : "+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆空间 : "+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("初始化堆空间 : "+Runtime.getRuntime().totalMemory()/1024/1024+"M");

        System.out.println("======================================");

        // byte  是 一个字节 , 所以是 10M
        byte[] b2 = new byte[5 * 1024 * 1024];
        System.out.println("分配5M的内存空间");
        System.out.println("最大堆空间 : "+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆空间 : "+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("初始化堆空间 : "+Runtime.getRuntime().totalMemory()/1024/1024+"M");

        System.out.println("======================================");
    }
}
