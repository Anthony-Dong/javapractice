package com.nio.nextstudy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 *
 * @date:2019/9/17 20:52
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Test {


    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);


        while (true) {
            int select = selector.select();//阻塞

            Set<SelectionKey> selectionKeys = selector.keys();

            if (selectionKeys.size() == 0) {
                return;
            }

            selectionKeys.forEach(selectionKey -> {
                // 如果是已连接的
                if (selectionKey.isAcceptable()) {

                    ServerSocketChannel  serverChannel = (ServerSocketChannel)selectionKey.channel();

                    System.out.println("serverChannel = " + serverChannel);
                    SocketChannel socketChannel = null;
                    try {
                         socketChannel = serverChannel.accept();//阻塞

                        if (null != socketChannel) {
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                    } catch (IOException e) {
//                        e.printStackTrace();
                    }

                } else if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    Integer read=0;
                    try {
                         read = channel.read(buffer);
                    } catch (IOException e) {
//                        e.printStackTrace();
                    }


                    if (read >0) {
                        buffer.flip();
                        Charset charset = Charset.forName("utf-8");
                        char[] array = charset.decode(buffer).array();

                        String msg = new String(array);

                        System.out.println(msg);

                        buffer.clear();
                    }
                }


            });



        }

    }

}
