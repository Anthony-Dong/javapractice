package com.nio.nextstudy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 *
 * @date:2019/9/17 17:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) throws Exception {

        // 创建一个selector对象
        Selector selector = Selector.open();



        int[] ports = {8000, 8001, 8002, 8003};

        for (int port : ports) {
            // 创建 server socket channel
            ServerSocketChannel channel = ServerSocketChannel.open();

            channel.configureBlocking(false);


            // Retrieves a server socket associated with this channel.
            ServerSocket socket = channel.socket();
            socket.bind(new InetSocketAddress(port));

            // 将channel 注册到 selector上
            channel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口 :"+port);
        }


        while (true) {

            int select = selector.select(); // 阻塞的

            if(select == 0) continue;

            System.out.println("连接数" + select);

            // 获取 注册的事件的channel对象
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("接收到的key" + selectionKeys);

            System.out.println(selectionKeys);

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey e = iterator.next();
                if (e.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) e.channel();
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        // Returns the channel for which this key was created.
                        // 所以下面的 e.channel(); 返回的是 SocketChannel对象
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("获取客户端连接:" + channel);
                        iterator.remove();
                } else if (e.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) e.channel();
                    int bytes=0;
                    ByteBuffer buffer = ByteBuffer.allocate(10);
                    while (true) {
                        buffer.clear();
                        int read = socketChannel.read(buffer);
                       // System.out.println(read);
                        if (read <= 0) {
                            break;
                        }
                        buffer.flip();
                        socketChannel.write(buffer);
                        bytes += read;
                    }
                    iterator.remove();
                    System.out.println(bytes);
                }

            }








        }


    }


}
