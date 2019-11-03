package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * TODO
 *
 * @date:2019/10/28 15:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestForkJoin {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool pool = new ForkJoinPool();

        CounterRecursiveTask task = new CounterRecursiveTask(0, 10);

        ForkJoinTask<Integer> submit = pool.submit(task);


        System.out.println("submit.get() = " + submit.get());


        System.out.println("IntStream.rangeClosed(0,100000).sum() = " + IntStream.rangeClosed(0, 10).sum());


    }


    static class CounterRecursiveTask extends RecursiveTask<Integer>{
        // 起始
        private int start;

        // 结束
        private int end;

        // fork 点
        private static final int MAX_SPLICE_NUMBER = 5;

        // 传入参数,构造方法
        public CounterRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Integer compute() {

            // 临界点
            if (end - start < MAX_SPLICE_NUMBER) {
                // 真正的计算逻辑在这里
                int sum = IntStream.rangeClosed(start, end).sum();
                System.out.println("执行计算 : "+sum);
                return sum;
            } else {
                // 这是向下取整
                int middle = (start + end) / 2;

                // 拆分子任务
                CounterRecursiveTask leftTasK = new CounterRecursiveTask(start, middle);

                CounterRecursiveTask rightTask = new CounterRecursiveTask(middle + 1, end);

                // 异步执行计算
                leftTasK.fork();
                rightTask.fork();

                System.out.printf("start : %s\tend : %s\tmiddle : %s\tinterval : %s\n\r", start, end, middle,(end-start));

                // 合并结果
                return leftTasK.join() + rightTask.join();
            }
        }
    }

}
