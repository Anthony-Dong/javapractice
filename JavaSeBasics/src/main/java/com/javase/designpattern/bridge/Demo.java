package com.javase.designpattern.bridge;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

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
