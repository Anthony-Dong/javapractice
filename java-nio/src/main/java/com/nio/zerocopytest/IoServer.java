package com.nio.zerocopytest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * TODO
 *
 * @date:2019/9/24 10:55
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class IoServer {


    public static void main(String[] args) throws IOException {

        //打开一个服务端通道 ,服务端ServerSocketChannel扮演者服务端通道的角色，
        // 它负责监听服务器上的一个连接，在创建服务端通道的时候需要调用对等的ServerSocket对象绑定到指定的端口上。
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //获得对等的ServerSocket对象 , SocketChannel扮演客户端发起同一个监听服务器的连接。
        ServerSocket socket = serverSocketChannel.socket();

        //将服务端ServerSocket绑定到指定端口
        socket.bind(new InetSocketAddress(8080));

        socket.setReuseAddress(true);

        ByteBuffer buffer = ByteBuffer.allocate(4096);


        while (true) {

            SocketChannel socketChannel = serverSocketChannel.accept();
            //将通道设置为非阻塞模式

            socketChannel.configureBlocking(false);


            int readCount = 0;

            while (-1 != readCount) {

                readCount = socketChannel.read(buffer);

                buffer.rewind();
            }

        }


    }


}
