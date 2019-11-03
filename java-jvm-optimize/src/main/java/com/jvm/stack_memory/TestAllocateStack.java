package com.jvm.stack_memory;

/**
 * TODO
 *
 * @date:2019/11/1 17:39
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestAllocateStack {

    static class User{
        String name;
    }

    private static User user;

    static void allocUser1(){
        user = new User();
        user.name = "name";
    }


    static void allocUser(){
        User user = new User();
        user.name = "name";
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for(int i = 0;i< 20000000;i++){
            allocUser1();
        }
        long e = System.currentTimeMillis();
        System.out.println("main进程 结束 ："+ (e-b));
        System.out.println("堆内存大小 : "+Runtime.getRuntime().maxMemory() / 1000 / 1000+"M");
    }
}
