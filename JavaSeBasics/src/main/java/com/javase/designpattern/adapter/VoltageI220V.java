package com.javase.designpattern.adapter;

/**
 * 需要适配的类(一般作为父类)  对
 *
 * @date:2019/9/7 11:10
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class VoltageI220V {


        int output(){
            System.out.println("我是 一个 220 v电压");

            return 220;
        }
}
