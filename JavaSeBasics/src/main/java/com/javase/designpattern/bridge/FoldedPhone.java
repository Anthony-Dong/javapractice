package com.javase.designpattern.bridge;

/**
 * TODO
 *
 * @date:2019/9/7 16:48
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class FoldedPhone extends Phone {


    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    void method() {
        super.method();
        System.out.println("--------------");
    }
}
