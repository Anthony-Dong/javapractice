package com.top_k;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 通过堆排序    O(nlogk)
 *
 * @date:2019/10/4 0:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestTopK02 {


    public static void main(String[] args) {

        PriorityQueue<Integer> pp = new PriorityQueue<>(1, Integer::compareTo);


        pp.add(10);
        pp.add(98);
        pp.add(50);



        /*for (Integer integer : pp) {
            System.out.println(integer);
        }

        System.out.println(pp.poll());

        System.out.println(pp.peek());

        System.out.println(pp.peek());*/

        int count = 20;
        int[] arrs = new int[count];

        for (int i = count-1; i >=0; --i) {
            arrs[i] = new SecureRandom().nextInt(20);
        }
        Arrays.stream(arrs).sorted().forEach(System.out::println);
    }


    public static int[] heapTopK(int[] arr,int count) {
        // 初始化堆 (小顶堆) 其实优先队列属于无界队列的 ....... 设置大小没用
        PriorityQueue<Integer> pp = new PriorityQueue<>(count,Integer::compareTo);

        // 添加count 个元素
        for (int i = 0; i < count; i++) {
            pp.add(arr[i]);
        }

        // 让从 第 count开始比较 和前面的
        for (int i = count; i < arr.length; i++) {
            // 堆顶元素
            Integer peek = pp.peek();

            // 如果 后面的大于 堆顶元素(最小的元素)
            if (peek < arr[count]) {
                // 把堆顶移除掉,然后将大于堆顶的元素添加进去
                pp.poll();
                pp.add(arr[count]);
            }
        }

        int[] outarr = new int[count];
        for (int i = 0; i < count; i++) {
            outarr[i] = pp.poll();
        }

        return outarr;

    }


}
