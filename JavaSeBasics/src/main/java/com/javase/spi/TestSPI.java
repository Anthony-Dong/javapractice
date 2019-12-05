package com.javase.spi;

/**
 * TODO
 *
 * @date:2019/12/2 12:18
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestSPI {


    public static void main(String[] args) {

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(contextClassLoader);

        System.out.println(ClassLoader.getSystemClassLoader());
    }


}
