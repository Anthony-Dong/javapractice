package com.javase.concurrent_package;

import java.util.LinkedList;

/**
 * TODO
 *
 * @date:2019/9/16 12:23
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class WaitingQueue<E> {
    private LinkedList<E> queue = new LinkedList<>();

    public synchronized void push(E e) {
        // push是往前添加
        // add是往后添加
        queue.push(e);
        this.notifyAll();

    }


    public synchronized E pop(){
        while (queue.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        WaitingQueue<Integer> integerWaitingQueue = new WaitingQueue<>();

        integerWaitingQueue.push(1);
        integerWaitingQueue.push(2);
        System.out.println("integerWaitingQueue.pop() = " + integerWaitingQueue.pop());
        System.out.println("integerWaitingQueue.pop() = " + integerWaitingQueue.pop());
//        System.out.println("integerWaitingQueue.pop() = " + integerWaitingQueue.pop());
    }

}
