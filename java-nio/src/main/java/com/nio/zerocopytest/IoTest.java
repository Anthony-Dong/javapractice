package com.nio.zerocopytest;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * TODO
 *
 * @date:2019/9/24 11:18
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class IoTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile source = new RandomAccessFile("D:\\学习视频\\AliyunPlayer_Web-master.zip", "rw");

        FileChannel outchannel = source.getChannel();

        RandomAccessFile destination = new RandomAccessFile("D:\\学习视频\\AliyunPlayer_Web-master1.zip", "rw");

        FileChannel inchannel = destination.getChannel();

        long postion = 0;

        long size = outchannel.size();

        outchannel.transferTo(postion, size, inchannel);

    }
}
