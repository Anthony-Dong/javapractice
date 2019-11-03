package com.jvm.direct_memory;

import java.nio.ByteBuffer;

/**
 *
 *
 * @date:2019/11/3 0:03
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestAllocDirectBuffer {

    public void allocDirect() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            ByteBuffer.allocateDirect(1024);
        }
        System.out.println("allocDirect : "+(System.currentTimeMillis() - start));
    }


    public void allocBuffer() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            ByteBuffer.allocate(1024);
        }
        System.out.println("allocBuffer : "+(System.currentTimeMillis() - start));
    }


    public static void main(String[] args) {

        TestAllocDirectBuffer allocDirectBuffer = new TestAllocDirectBuffer();

        allocDirectBuffer.allocBuffer();
        allocDirectBuffer.allocDirect();

        System.out.println("===============================");

        allocDirectBuffer.allocBuffer();
        allocDirectBuffer.allocDirect();
    }
}
