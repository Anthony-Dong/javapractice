package com.SocketIO.NoBlockingIO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName:NoBlockingReactorServer
 * Package:com.SocketIO.NoBlockingIO
 * Description:
 *
 * @date:2019/7/26 18:52
 * @author: 574986060@qq.com
 */

public class NoBlockingReactorServer {
//    连接池
    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;

    public static void main(String[] args) throws Exception {
        NoBlockingReactorServer server = new NoBlockingReactorServer();
        server.initServer(8000);
        server.listen();
    }

    public void initServer(int port) throws IOException {
        //
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //
        serverChannel.configureBlocking(false);
        //
        serverChannel.socket().bind(new InetSocketAddress(port));
        //
        this.selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功！");
    }

//    @SuppressWarnings("unchecked")
    public void listen() throws IOException {
        // 轮询访问selector
        while (true) {
            //
            selector.select();
            //
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                //
                ite.remove();
                //
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //
                    SocketChannel channel = server.accept();
                    //
                    channel.configureBlocking(false);
                    //
                    channel.register(this.selector, SelectionKey.OP_READ);
                    //
                } else if (key.isReadable()) {
                    //
                    key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
                    //
                    pool.execute(new ThreadHandlerChannel(key));
                }
            }
        }
    }


    public class ThreadHandlerChannel extends Thread {
        private SelectionKey key;

        ThreadHandlerChannel(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            //
            SocketChannel channel = (SocketChannel) key.channel();
            //
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                int size = 0;
                while ((size = channel.read(buffer)) > 0) {
                    buffer.flip();
                    baos.write(buffer.array(), 0, size);
                    buffer.clear();
                }
                baos.close();
                //
                byte[] content = baos.toByteArray();
                ByteBuffer writeBuf = ByteBuffer.allocate(content.length);
                writeBuf.put(content);
                writeBuf.flip();
                channel.write(writeBuf);//
                if (size == -1) {

                    channel.close();
                } else {
                    //
                    key.interestOps(key.interestOps() | SelectionKey.OP_READ);
                    key.selector().wakeup();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}



