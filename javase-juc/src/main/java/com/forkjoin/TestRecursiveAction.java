package com.forkjoin;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @date:2019/10/28 16:19
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestRecursiveAction {


    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool pool = new ForkJoinPool();

        CounterRecursiveAction task = new CounterRecursiveAction(0, 10);

        pool.submit(task);

        pool.awaitTermination(1, TimeUnit.SECONDS);

        System.out.println(CounterRecursiveAction.getSum());

        System.out.println("IntStream.rangeClosed(0,100000).sum() = " + IntStream.rangeClosed(0, 10).sum());


    }


    static class CounterRecursiveAction extends RecursiveAction {
        // 起始
        private int start;

        // 结束
        private int end;

        // 计算结果
        private  static int sum = 0;

        public static int getSum() {
            return sum;
        }

        // fork 点
        private static final int MAX_SPLICE_NUMBER = 5;

        // 传入参数,构造方法
        public CounterRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        protected void compute() {
            // 临界点
            if (end - start < MAX_SPLICE_NUMBER) {
                // 怎么处理 sum  就是个问题
                synchronized (this) {
                    int sums = IntStream.rangeClosed(start, end).sum();
                    sum += sums;
                    System.out.println(Thread.currentThread().getName()+"  "+"sums = " + sums+" sum : "+sum);
                }
            } else {
                // 这是向下取整
                int middle = (start + end) / 2;

                // 拆分子任务
                CounterRecursiveAction leftTasK = new CounterRecursiveAction(start, middle);

                CounterRecursiveAction rightTask = new CounterRecursiveAction(middle + 1, end);

                // 异步执行计算
                leftTasK.fork();
                rightTask.fork();

                System.out.printf("start : %s\tend : %s\tmiddle : %s\tinterval : %s\n\r", start, end, middle, (end - start));


                // 合并结果
                invokeAll(leftTasK, rightTask);

            }
        }
    }

}
