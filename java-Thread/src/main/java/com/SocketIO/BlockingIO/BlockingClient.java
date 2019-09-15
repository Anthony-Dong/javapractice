package com.SocketIO.BlockingIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ClassName:BlockingClient
 * Package:com.SocketIO.BlockingIO
 * Description:
 *
 * @date:2019/7/26 17:34
 * @author: 574986060@qq.com
 */

public class BlockingClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);

        System.out.println("ok");
        try( OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream()) {
            String msg = "hello  blocking io";
            outputStream.write(msg.getBytes());
            byte[] data = new byte[1024];
            inputStream.read(data);
            System.out.println(new String(data, 0, data.length));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
