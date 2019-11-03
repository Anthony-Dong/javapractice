package com.jvm.direct_memory;

import java.nio.ByteBuffer;

/**
 * TODO
 *
 * @date:2019/11/2 23:50
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDirectMemoryAccess {

    public void directAccess(){
        long start = System.currentTimeMillis();

        ByteBuffer buffer = ByteBuffer.allocateDirect(4000);

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 1000; j++) {
                buffer.put((byte) j);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                buffer.get();
            }
            buffer.clear();
        }

        System.out.println("directAccess : "+(System.currentTimeMillis() - start));
    }


    public void bufferAccess(){
        long start = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(4000);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 1000; j++) {
                buffer.put((byte) j);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                buffer.get();
            }
            buffer.clear();
        }

        System.out.println("bufferAccess : "+(System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        TestDirectMemoryAccess directMemory = new TestDirectMemoryAccess();

        directMemory.bufferAccess();
        directMemory.directAccess();

        System.out.println("=====================");

        directMemory.bufferAccess();
        directMemory.directAccess();
    }


}
