package com.nio.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

/**
 *  io 流 关联 channel
 *
 * @date:2019/9/16 19:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


public class OpenChannelTest02 {


    public static void main(String[] args) throws Exception {

        // model <tt>"r"</tt>, <tt>"rw"</tt>, <tt>"rws"</tt>
        RandomAccessFile input = new RandomAccessFile("input.txt", "r");
        RandomAccessFile output = new RandomAccessFile("output.txt", "rw");
        // 打开一个管道
        FileChannel readChannel = input.getChannel();
        FileChannel writeChannel = output.getChannel();

        // allocateDirect(100)对外内存   allocate(100)
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);

        while (true) {
            System.out.println("position1 : "+buffer.position());

            System.out.println("limit1 : "+buffer.limit());

            buffer.clear();
            int read = readChannel.read(buffer);
            // 如果不clear  position=limit , 那么这个buffer,根本没法存入数据,所以返回0
            System.out.println(read);
            System.out.println("position : "+buffer.position());

            System.out.println("limit : "+buffer.limit());


//            System.out.println(read);

            TimeUnit.SECONDS.sleep(2);

            if (read == -1) {
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        input.close();
        output.close();

    }


}
