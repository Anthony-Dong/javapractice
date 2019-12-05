package com.javase.valueof_parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * TODO
 *
 * @date:2019/11/19 22:39
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Java {


    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Java.class.getClassLoader().getResourceAsStream("com/javase/annotation_test/Child.class");


        byte[] arr = new byte[2048];

        resourceAsStream.read(arr);


        for (byte b : arr) {
            System.out.printf("%d\t",b);
        }


        System.out.println();
        char c = 'C';

        System.out.println((byte) c);

    }


}
