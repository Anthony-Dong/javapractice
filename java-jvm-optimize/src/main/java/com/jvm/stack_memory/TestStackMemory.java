package com.jvm.stack_memory;

/**
 * TODO
 *
 * @date:2019/11/1 16:43
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestStackMemory {
    static int count = 0;
    static void test(){
        long a=100,s=100,d=10,f=100,g=100,h=10;
        count++;
        test();
    }

    static void test2(){
        {
            int a = 1;
            System.out.println("------------");
        }
        int b = 0;
    }

    public static void main(String[] args) {
        try {
            test2();
        } catch (Throwable e) {
            System.out.println("recursive count : " + count);
            e.printStackTrace();
        }
    }
}
