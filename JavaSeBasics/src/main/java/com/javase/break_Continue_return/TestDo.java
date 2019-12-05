package com.javase.break_Continue_return;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @date:2019/11/14 21:24
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDo {


    @Test
    public void testReturn(){
        int x = 1;
        while (true) {
            System.out.println(x++);
            if (x == 5) {
                return;
            }
            System.out.println("=======Continue==========");
        }

    }


    @Test
    public void testBreak() throws InterruptedException {
        int x = 1;
        while (true) {

            TimeUnit.MILLISECONDS.sleep(200);

            System.out.println(x++);
            if (x == 5) {
                break;
            }
        }
        System.out.println("=======break==========");
    }


    @Test
    public void testContinue() throws InterruptedException {
        int x = 1;
        while (true) {

            TimeUnit.MILLISECONDS.sleep(200);

            System.out.println(x++);
            if (x == 5) {
                continue;
            }

            System.out.println("=======Continue==========");
        }

    }


}
