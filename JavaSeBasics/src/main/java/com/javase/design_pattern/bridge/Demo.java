package com.javase.design_pattern.bridge;

/**
 * TODO
 *
 * @date:2019/9/7 16:50
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        Phone foldedPhone = new FoldedPhone(new HuaWei());

        foldedPhone.method();


    }


}
