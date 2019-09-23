package com.nio.start;

import java.io.BufferedInputStream;

import java.io.FileInputStream;

import java.io.FilterInputStream;

/**
 * 这里涉及到 三个概念
 *              - 超类 InputStream
 *              - 节点流 {@link FileInputStream}
 *              -  过滤流  {@link FilterInputStream}
 *                  - 子类 {@link BufferedInputStream}
 *
 * @date:2019/9/16 18:36
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class IOTest {


    public static void main(String[] args) throws Exception{

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("D:\\代码库\\javase学习\\DevelopmentJAVA\\java-nio\\a.txt"));


        byte[] bytes = new byte[1024];

        inputStream.read(bytes);

        System.out.println(new String(bytes));
        inputStream.close();

        System.out.println(System.getProperty("user.dir"));
    }


}
