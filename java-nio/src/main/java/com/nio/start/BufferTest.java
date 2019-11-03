package com.nio.start;


import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 *  了解 buffer这个概念 , 他究竟在 nio中扮演什么样的角色
 *
 *  java中 一共 8个基本类型,对于 8个buffer对象
 * @date:2019/9/16 18:46
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class BufferTest {

    public static void main(String[] args) {

        // 创建一个 buffer对象 ,设置其大小为 50
        IntBuffer buffer = IntBuffer.allocate(20);
        // 往 buffer中写入数据
        for (int i = 0; i < 30; i++) {
            buffer.put(new SecureRandom().nextInt(10));
        }


        // 进行翻转 ,如果不使用这个 会发现什么 ,---> 其实这个作用就是让




        // 读  remaining是剩余的意思
        while (buffer.remaining()>0) {
            System.out.printf("%s\t",buffer.get());
        }
    }


}
