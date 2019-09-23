package com.nio.start;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * TODO
 *
 * @date:2019/9/17 14:20
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class FileLockTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\modify.txt", "rw");


        FileLock lock = file.getChannel().lock(1,6,true);

        System.out.println(lock.isValid());

        System.out.println(lock.isShared());
        lock.release();

        file.close();
    }


}
