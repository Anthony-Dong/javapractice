package com.javase.Keyword.enum_test;



//import static com.javase.Keyword.enum_test.Constant.*;

/**
 *
 *
 * @date:2019/10/5 0:12
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {


        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {

            System.out.println(stackTraceElement.getMethodName());
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        System.out.println(classLoader);
    }


}
