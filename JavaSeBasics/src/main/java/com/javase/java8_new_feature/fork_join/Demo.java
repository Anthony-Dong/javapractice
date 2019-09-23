package com.javase.java8_new_feature.fork_join;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * TODO
 *
 * @date:2019/9/19 12:07
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo  extends RecursiveTask<Long> {
    private Long start;//起始值
    private Long end;//结束值
    public static final  Long critical = 100000000L;//临界值

    public Demo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long lenth = end - start;
        if (lenth <= critical) {
            Long sum = 0L;

            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (end + start) / 2;

            Demo right = new Demo(start, middle);

            right.fork();


            Demo left = new Demo(start, middle);

            left.fork();

            return right.join() + left.join();

        }

    }


 /*   public static void main(String[] args) {

        //ForkJoin实现
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();//实现ForkJoin 就必须有ForkJoinPool的支持
        ForkJoinTask<Long> task = new Demo(0L,10000000000L);//参数为起始值与结束值
        Long invoke = forkJoinPool.invoke(task);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + invoke+"  time: " + (l1-l));
    }*/

    public static void main(String[] args) {
        //Java 8 并行流的实现
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + reduce+"  time: " + (l1-l));
    }



}
