package com.javase.day02;

import org.junit.Test;

/**
 * ClassName:INTMethod
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 10:57
 * @author: 574986060@qq.com
 */

public class INTMethod {


    @Test
    public void test() {

        /**
         * 强转 int 是 向下 取整
         */
        System.out.println((int) 1.1);
        System.out.println((int) 1.5);
        System.out.println((int) 1.6);

        /**
         * Math.ceil(1.8)   向上取整
         * Math.floor(1.8)  向下取整
         * Math.round(1.8)  四舍五入
         */
        System.out.println(Math.ceil(1.8));
        System.out.println(Math.floor(1.8));
        System.out.println(Math.round(1.8));

//        10/2 5-0 5/2=2-1  2/2=1-0  1/2 =0/1  1010(10) ---- 101()+1= 6   6=4+2+0 110  11 3
        int i = ((10 >> 1) + 1) >> 1;
        System.out.println(i);

    }
}
