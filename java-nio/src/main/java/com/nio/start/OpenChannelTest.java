package com.nio.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  io 流 关联 channel
 *
 * @date:2019/9/16 19:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


public class OpenChannelTest {


    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\a.txt");

        // 打开一个管道
        FileChannel channel = stream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(100);
        // 读取到 buffer中
        channel.read(buffer);

        // 翻转
        buffer.flip();

        while (buffer.remaining() > 0) {
            System.out.println((char) buffer.get());
        }
        stream.close();

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\out.txt");

        FileChannel channel1 = fileOutputStream.getChannel();

        // 翻转
        buffer.flip();
        channel1.write(buffer);

        fileOutputStream.flush();
        fileOutputStream.close();

    }


}
