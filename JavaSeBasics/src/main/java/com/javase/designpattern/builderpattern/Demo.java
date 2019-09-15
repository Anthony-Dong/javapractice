package com.javase.designpattern.builderpattern;

/**
 * TODO
 *
 * @date:2019/9/6 23:31
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {
        MyBuilder myBuilder = new MyBuilder();

        MyFactory build = myBuilder.build("1111111111","222222222222");

        MyProduct myProduct = build.create();


        String show = myProduct.show();

        System.out.println(show);

    }


}
