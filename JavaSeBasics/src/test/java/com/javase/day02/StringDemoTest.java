package com.javase.day02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName:StringDemoTest
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 10:08
 * @author: 574986060@qq.com
 */

public class StringDemoTest {
    private StringBuffer str =new StringBuffer();

    @Test
    public  void test(){
/*
        String a = "hello";
        System.out.println(a.hashCode());
        a = a + "world";
        System.out.println(a.hashCode());

        char[] arr = "AA".toCharArray();
        int i = hashCode(0, arr);
        System.out.println(i);
        char[] arr1 = "BB".toCharArray();
        int i1 = hashCode(0, arr);
        System.out.println(i1);
//        s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

*/


        str =new StringBuffer("aaa");
        System.out.println(str.hashCode());

        str =new StringBuffer("BBB");
        System.out.println(str.hashCode());

    }

   /* public int hashCode(int hash,char[] value) {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }*/
}