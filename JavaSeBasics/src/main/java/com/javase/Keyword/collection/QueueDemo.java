package com.javase.Keyword.collection;


import java.util.concurrent.*;

/**
 * TODO
 *
 * @date:2019/9/11 22:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class QueueDemo {


    public static void main(String[] args) throws Exception{

        offer(new ArrayBlockingQueue<Integer>(2));
        offer(new LinkedBlockingDeque<Integer>(2));
        offer(new PriorityBlockingQueue<Integer>(2));
        offer(new SynchronousQueue<Integer>());


    }

    private static void offer(BlockingQueue<Integer> queue) throws Exception {

        System.out.println("queue.getClass().getName() = " + queue.getClass().getName());
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());
    }

}
