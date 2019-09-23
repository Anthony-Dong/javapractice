package com.javase.designpattern.decorator;

import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * 最简单的装饰着模式的实现例子   可以参考{@link InputStream}  和  {@link FilterInputStream}
 *
 *  其实就是 实现了代码的灵活性 和
 * @date:2019/9/16 17:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {

        Component component = new Decorator2(new Decorator1(new ComplateComponent()));


        component.doSomething();

        System.out.println();
    }


}
