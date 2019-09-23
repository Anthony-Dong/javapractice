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


public class OpenChannelTest02 {


    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\out.txt");
        // 打开一个管道
        FileChannel readChannel = stream.getChannel();
        FileChannel writeChannel = fileOutputStream.getChannel();

        // allocateDirect(100)   allocate(100)
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);

        while (true) {
            buffer.clear();
            int read = readChannel.read(buffer);
            System.out.println(read);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        stream.close();
        fileOutputStream.close();

    }


}
