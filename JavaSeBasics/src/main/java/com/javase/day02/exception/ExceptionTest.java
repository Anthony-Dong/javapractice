package com.javase.day02.exception;

import org.junit.Test;

/**
 * ClassName:ExceptionTest
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 10:37
 * @author: 574986060@qq.com
 */

public class ExceptionTest {

    /**
     * exception  和 error类的使用  父类都是  throwable
     * @return
     */
    public static int test03() {
        try {
            int i = 1 / 0;
//                遇到异常 不执行  了 调出 try
            return 1;
        } catch (Exception e) {
// 有finally 必须先走 finally
            return 2;
        } finally {
            return 3;
        }

    }

    @Test
    public void test() {
        int i = test03();
        System.out.println(i);

    }
    @Test
    public void test01() throws ExceptionBean {

        try {
           int i=1/1;
        } catch (Exception e) {
//

            throw new ExceptionBean();
        }


    }
}
