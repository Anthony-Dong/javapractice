package com.mytest;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;



/**
 * ClassName:TimeClient
 * Package:com.mytest
 * Description:
 *
 * @date:2019/7/26 22:59
 * @author: 574986060@qq.com
 */

public class TimeClient {
    public static void main(String[] args) throws Exception {
        int port=8080; //服务端默认端口
        new TimeClient().connect(port, "127.0.0.1");
    }
    public void connect(int port, String host) throws Exception{
        //配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bs = new Bootstrap();
            bs.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        //创建NIOSocketChannel成功后，在进行初始化时，将它的ChannelHandler设置到ChannelPipeline中，用于处理网络IO事件
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //处理粘包/拆包问题

                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new TimeClientHandler());
                        }
                    });
            //发起异步连接操作
            ChannelFuture cf = bs.connect(host, port).sync();
            //等待客户端链路关闭
            cf.channel().closeFuture().sync();
        } finally {
            //优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }


}

class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private int counter;
    private byte[] req;

    @Override
    //向服务器发送指令
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message=null;
        //模拟一百次请求，发送重复内容
        for (int i = 0; i < 200; i++) {
            req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
            message= Unpooled.buffer(req.length);
            message.writeBytes(req);
            ctx.writeAndFlush(message);
        }

    }

    @Override
    //接收服务器的响应
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        //buf.readableBytes():获取缓冲区中可读的字节数；
//        //根据可读字节数创建数组
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String) msg;
        System.out.println("Now is : "+body+". the counter is : "+ ++counter);
    }

    @Override
    //异常处理
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //释放资源
        ctx.close();
    }

}