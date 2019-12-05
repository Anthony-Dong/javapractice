package com.javase.autobox_and_unbox;

import java.util.HashMap;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * TODO
 *
 * @date:2019/11/14 21:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestInteger {

    public static void main(String[] args) {


        PriorityBlockingQueue<Object> objects = new PriorityBlockingQueue<>(1);


        objects.add(11);
        objects.add(222);

        objects.add(33);

        System.out.println("objects = " + objects.size());

    }


}
class P implements Comparable<P>{

    String msg;



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int hashCode() {
        return 1;
    }


    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public P(String msg) {
        this.msg = msg;
    }

    // o 指的前一个
    @Override
    public int compareTo(P o) {
        System.out.println(this.msg.length());
        System.out.println(o.msg.length());

        return Integer.compare(this.msg.length(), o.msg.length());
    }
}
