package com.SocketIO.netty;

/**
 * ClassName:DoNetty
 * Package:com.SocketIO.netty
 * Description:
 *
 * @date:2019/7/26 19:36
 * @author: 574986060@qq.com
 */

public class DoNettyServer {

    public static void main(String[] args) {
        new NettyServer(8888).startNettyServer();

    }
}
