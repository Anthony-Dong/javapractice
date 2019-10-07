package com.nio.zerocopytest;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 客户端
 *
 * @date:2019/9/24 10:47
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class IoClient {


    public static void main(String[] args) throws Exception {


        //Java NIO中的SocketChannel是一个 连接 到TCP网络套接字的通道
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.socket().connect(new InetSocketAddress(8080));

        socketChannel.configureBlocking(false);




        String filename = "D:\\学习视频\\solr-8.1.1.zip";
        FileChannel channel = new FileInputStream(filename).getChannel();

        long start = System.currentTimeMillis();
        // 这个更快
        channel.transferTo(0, channel.size(), socketChannel);


        long end = System.currentTimeMillis();

        System.out.println("时间" + (end - start) + "大小" + (channel.size()));

        channel.close();

        socketChannel.close();

    }


}
