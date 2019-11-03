package com.javase.design_pattern.decorator;

/**
 * TODO
 *
 * @date:2019/9/16 17:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ComplateComponent implements Component {


    @Override
    public void doSomething() {
        System.out.println("功能A");
    }
}
