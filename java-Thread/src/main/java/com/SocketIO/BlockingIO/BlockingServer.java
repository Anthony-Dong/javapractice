package com.SocketIO.BlockingIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ClassName:BlockingService
 * Package:com.SocketIO.BlockingIO
 * Description:
 *
 * @date:2019/7/26 17:24
 * @author: 574986060@qq.com
 */

public class BlockingServer{
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    public static void main(String[] args) throws Exception {
        ServerSocket socket = new ServerSocket();

        socket.bind(new InetSocketAddress("localhost", 8088));

        while (true) {
            Socket s = socket.accept();
            System.out.println("请求连接");
            new Thread(() -> {
                try {
                    handlerClient(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    public static void handlerClient(Socket socket)  {
        try(InputStream inputStream = socket.getInputStream();OutputStream outputStream = socket.getOutputStream();) {

            byte[] data = new byte[1024];
            inputStream.read(data);

            outputStream.write(data, 0,data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
