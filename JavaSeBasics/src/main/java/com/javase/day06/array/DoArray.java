package com.javase.day06.array;

import java.util.HashMap;

/**
 * ClassName:DoArray
 * Package:com.javase.day06.array
 * Description:
 *
 * @date:2019/7/7 0:09
 * @author: 574986060@qq.com
 */

public class DoArray {
    private DoArray next;
    private Object data;

    public DoArray(Object data) {
        this.data = data;
    }

    public DoArray(DoArray next, Object data) {
        this.next = next;
        this.data = data;
    }

    public static void main(String[] args) {
        DoArray doArray = new DoArray("0");
        DoArray doArray1 = new DoArray(doArray, "1");
        doArray.next = doArray1;

        System.out.println(doArray.getNext().getData());
        System.out.println(doArray1.getNext().getData());
    }

    public DoArray getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }
}
