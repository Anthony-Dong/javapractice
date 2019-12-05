package com.javase.exception;


/**
 * TODO
 *
 * @date:2019/11/14 22:35
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestException {


    public static void main(String[] args) {

        TestException testException = new TestException();


        try {
            testException.testS();
        } catch (Exception e) {
            if (e instanceof MyException) {
                System.out.println("真的对了");
            }

            System.out.println(e.getMessage());
        }


    }

    /**
     * throw 的意思是 抛出自定义的一个异常
     *
     * throws Exception 的意思是 抛出去外面 , 调用我的人必须去抓取异常
     */
    public void testS() throws Exception{
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            throw new MyException("我的异常");
        }
    }
}
