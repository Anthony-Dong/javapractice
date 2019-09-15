package com.javase.Keyword.collection;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * TODO
 *
 * @date:2019/9/11 22:10
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class QueueQuestion {

    public static void main(String[] args) throws Exception {


        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(4);

        int i = 10000;

        for (int i1 = 0; i1 < i; i1++) {
            queue.add(i1);
        }

        queue.add(9);
        queue.add(1);
        queue.add(8);

        System.out.println("queue.size() = " + queue.size());




//        System.out.println(10>>>1);
    }
}
