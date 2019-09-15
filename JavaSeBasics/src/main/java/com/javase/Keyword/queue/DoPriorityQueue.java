package com.javase.Keyword.queue;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TODO
 *
 * @date:2019/9/7 18:54
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DoPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<String> strings = new PriorityQueue<>();

        // 添加
        boolean add = strings.add("1111111111");

        System.out.println(add);
        // 添加一个元素 返回 true
        boolean offer = strings.offer("11111111111111");

        System.out.println(offer);

        // 返回头部元素 么有就返回 null
        String peek = strings.peek();
        System.out.println("peek = " + peek);


        // 移除
        String poll = strings.poll();
        System.out.println("poll = " + poll);

        // 返回头部元素 没有就抛出异常
        String element = strings.element();
        System.out.println("element = " + element);

        PriorityQueue<Integer> integers = new PriorityQueue<>();

        for (int u = 0; u < 10; u++) {
            integers.add(u);
        }

        System.out.println(integers.size());
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.remove());
        }

        System.out.println(integers.size());

    }
}
