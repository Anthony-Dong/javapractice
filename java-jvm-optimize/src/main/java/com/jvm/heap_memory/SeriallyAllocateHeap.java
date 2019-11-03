package com.jvm.heap_memory;

/**
 * TODO
 *
 * @date:2019/11/2 16:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class SeriallyAllocateHeap {

    public static void main(String[] args) {


        byte[] menory = null;

        System.out.println("============= 初始化内存空间 =========================");
        System.out.println("最大堆空间 : "+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.println("空闲堆空间 : "+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.println("初始化堆空间 : "+Runtime.getRuntime().totalMemory()/1024/1024+"M");


        for (int i = 0; i < 5; i++) {
            // 创建一块 1M 大小的 空间
            menory = new byte[2 * 1024 * 1024];
            System.out.println("=============="+"分配第"+(i+1)+"次"+"========================");
            System.out.println("最大堆空间 : "+Runtime.getRuntime().maxMemory()/1024/1024+"M");
            System.out.println("空闲堆空间 : "+Runtime.getRuntime().freeMemory()/1024/1024+"M");
            System.out.println("初始化堆空间 : "+Runtime.getRuntime().totalMemory()/1024/1024+"M");

        }

        System.out.println("============= 结束 =========================");
    }
}
