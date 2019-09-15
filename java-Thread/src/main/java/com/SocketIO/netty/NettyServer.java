package com.SocketIO.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * ClassName:NettyServer
 * Package:com.SocketIO.netty
 * Description:
 *
 * @date:2019/7/26 19:37
 * @author: 574986060@qq.com
 */

public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void startNettyServer(){
        EventLoopGroup bossNettyGroup = new NioEventLoopGroup();

        EventLoopGroup workNettyGroup = new NioEventLoopGroup();

        ServerBootstrap boot = new ServerBootstrap();

        boot.group(bossNettyGroup, workNettyGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new Handler());
                    }
                });

        try {
            ChannelFuture f = boot.bind(port).sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workNettyGroup.shutdownGracefully();
            bossNettyGroup.shutdownGracefully();
        }

    }

    class Handler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//            super.channelRead(ctx, msg);

            System.out.println(msg.toString());

            ctx.writeAndFlush(msg);
            ctx.close();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//            super.exceptionCaught(ctx, cause);

            cause.printStackTrace();
            ctx.close();
        }
    }

}
