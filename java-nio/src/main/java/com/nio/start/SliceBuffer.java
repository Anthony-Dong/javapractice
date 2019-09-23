package com.nio.start;

import java.nio.ByteBuffer;

/**
 *
 *  buffer.slice(); 他和 原有的buffer 共享 一个buffer数组,所以修改就修改到了原来的buffer
 *  buffer.asReadOnlyBuffer(); 只读buffer
 *
 * @date:2019/9/17 12:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class SliceBuffer {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(20);

        for (int i = 0; i < 10; i++) {
            buffer.put((byte) i);
        }


        System.out.println("-------------------------");

        // 只读buffer
        ByteBuffer buffer1 = buffer.asReadOnlyBuffer();
        buffer1.flip();

        while (buffer1.hasRemaining()) {

            System.out.println(buffer1.get());
        }

        System.out.println("-------------------------");

        int position = buffer.position();
        buffer.limit(8);
        buffer.position(5);

        ByteBuffer slice = buffer.slice();

        for (int i = 0; i < slice.capacity(); i++) {


            slice.put(i, (byte) 10);
        }


       // 此时 position是5如果 flip 则 会发现 position=0 limit=5,此时输出 0 1 2 3 4
        buffer.position(0);
        buffer.limit(position);

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }




    }


}
