package com.nio.start;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @date:2019/9/17 14:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\modify.txt", "rw");

        MappedByteBuffer buffer = file.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 10);

        buffer.put(0, (byte) 'a');
        buffer.put(4, (byte) 'a');

        file.close();
    }


}
