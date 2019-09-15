package com.javase.day03.lengthMethod;

import org.junit.Test;

/**
 * ClassName:LengthMethod
 * Package:com.javase.day03.lengthMethod
 * Description:
 *
 * @date:2019/7/1 11:08
 * @author: 574986060@qq.com
 */

public class LengthMethod {
    /**
     * string  里  length() 是 方法
     *
     *数组里 是 length属性
     *
     */
    @Test
    public void test() {
        String s = new String("111");
        s.length();


        String[] msg = new String[3];
        int j = msg.length;



        int[] arr = {1, 2, 3};

        int c=arr.length;


        for (int i = 0; i < arr.length; i++) {
            System.out.println(i);
        }


    }


}
