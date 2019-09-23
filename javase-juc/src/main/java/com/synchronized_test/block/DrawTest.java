package com.synchronized_test.block;
/**
 *  测试
 *
 * @date:2019/9/22 15:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class DrawTest {
    public static void main(String[] args){



        Account acct=new Account("1234567",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}