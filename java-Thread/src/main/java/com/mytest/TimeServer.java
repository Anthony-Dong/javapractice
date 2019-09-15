package com.mytest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;

/**
 * ClassName:TimeServer
 * Package:com.mytest
 * Description:
 *
 * @date:2019/7/26 22:38
 * @author: 574986060@qq.com
 */

public class TimeServer {

    public static void main(String[] args) {
        int port=8080; //服务端默认端口
        new TimeServer().bind(port);
    }

    public void bind(int port) {
//        reactor 组

//        1\用于服务端接受客户端连接的
        EventLoopGroup acceptorGroup = new NioEventLoopGroup();
//        用于进行 socketChannel 的网络读写
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //Netty用于启动NIO服务器的辅助启动类
            ServerBootstrap sb = new ServerBootstrap();
            //将两个NIO线程组传入辅助启动类中
            sb.group(acceptorGroup, workerGroup)
                    //设置创建的Channel为NioServerSocketChannel类型
                    .channel(NioServerSocketChannel.class)
                    //配置NioServerSocketChannel的TCP参数
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //设置绑定IO事件的处理类
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //每次连接都会执行initChannel方法
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //每次数据传输都会执行addLast里面的方法
                            //处理粘包/拆包问题
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new TimeServerHandler());
                        }
                    });
            //绑定端口，同步等待成功（sync()：同步阻塞方法）
            //ChannelFuture主要用于异步操作的通知回调
            ChannelFuture cf = sb.bind(port).sync();

            //等待服务端监听端口关闭
            cf.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        //优雅退出，释放线程池资源

            acceptorGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

}

class TimeServerHandler extends ChannelInboundHandlerAdapter {


    private int counter;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        //buf.readableBytes():获取缓冲区中可读的字节数；
//        //根据可读字节数创建数组
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String) msg;
        System.out.println("The timer_task server(Thread:"+Thread.currentThread()+") receive order : "+body+". the counter is : "+ ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");

        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        //将待发送的消息放到发送缓存数组中
        ctx.writeAndFlush(resp);
    }
}

