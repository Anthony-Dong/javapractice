package com.nio.start;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * TODO
 *
 * @date:2019/9/17 14:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Test {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channels = ServerSocketChannel.open();

        channels.bind(new InetSocketAddress(8080));


        SocketChannel channel = channels.accept();

        int bufferLen = 1 + 2 + 3;
        ByteBuffer buffer1 = ByteBuffer.allocateDirect(1);
        ByteBuffer buffer2 = ByteBuffer.allocateDirect(2);
        ByteBuffer buffer3 = ByteBuffer.allocateDirect(3);


        ByteBuffer[] buffers = {buffer1, buffer2, buffer3};


        while (true) {

            int length = 0;

            while (length<bufferLen){
                long read = channel.read(buffers);
                System.out.println("read = " + read);
                length += read;
            }
            // 会一个一个去读 ,所以需要限制

            Arrays.asList(buffers).forEach((e)->{
                e.flip();
            });


            int wlength = 0;

            while (wlength<bufferLen){
                long write = channel.write(buffers);

                System.out.println("write = " + write);
                wlength += write;
            }


            Arrays.asList(buffers).forEach((e)->{
                e.clear();
            });

        }


    }


}
