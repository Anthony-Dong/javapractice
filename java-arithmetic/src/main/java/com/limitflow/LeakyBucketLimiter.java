package com.limitflow;

import com.limitflow.module.FilterChain;
import com.limitflow.module.ServletRequest;
import com.limitflow.module.ServletResponse;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;


/**
 * 桶的思想就是 , 比如一开始我的桶0以放100个请求的 ,现在来了100个请求,  但是我的桶流速只有 10个/S ,
 * 那么这100个请求全接了 ,但是 流出去很10S
 * <p>
 * 所以我们以生产者消费者模型来想这个问题 就是 : 生产者就是我们的请求 ,消费者就是我们的漏斗 ,
 * <p>
 * 生产者 : 请求过来第一先判断是否满了, 没有满就把我加进去 , 满了我就不进去了
 * 消费者 : 我们的漏斗 我们漏斗不管你, 我就每秒只能过去10个 , 我们无法做到就是那种均匀速率,
 * 打个比方 : 1S内过去10个 , 我们每隔 100ms 睡眠一次, 那么1S内均匀过去 10个 , 但是你想过睡眠耽误的时间真的10个加起来是1S 吗
 *
 * @date:2019/12/4 22:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class LeakyBucketLimiter extends AbstractLimiter {

    /**
     * 我们的漏斗
     */
    private final LeakyBucket leakyBucket;

    /**
     * 构造器 , 输入每秒最大流量
     *
     * @param MAX_FlOW 最大流量
     */
    public LeakyBucketLimiter(int MAX_FlOW) {
        super(MAX_FlOW);
        this.leakyBucket = new LeakyBucket(MAX_FlOW);
    }

    /**
     * 具体实现的方法
     *
     * @param request  请求
     * @param response 响应
     * @param chain    执行
     */
    @Override
    public void limit(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            // 1. 获取桶当前水的大小
            int size = leakyBucket.bucket.size();

            // 2. 比较桶里的水是否满了
            if (size < leakyBucket.waterSize) {

                // 没有满我们就将水放进去
                leakyBucket.bucket.put(new Water(request, response, chain));
            }
        } catch (InterruptedException e) {
            //
        }
    }

    static class LeakyBucket {

        /**
         * 能放多少水,其实就是队列大小
         */
        final int waterSize;

        /**
         * 我们的放水的桶
         */
        final ArrayBlockingQueue<Water> bucket;

        public LeakyBucket(int MAX_FlOW) {
            this.waterSize = MAX_FlOW;
            bucket = new ArrayBlockingQueue<>(this.waterSize);

            /**
             * 模拟消费 , 1S只能过去100个 ,说明 100ms 可以消耗10个, 看你的颗粒度
             */
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // 100ms 流出去10个
                    for (int i = 0; i < (waterSize / 10); i++) {
                        try {
                            // 流出的水
                            Water water = bucket.take();

                            // 执行掉
                            water.chain.doFilter(water.request, water.response);
                        } catch (InterruptedException e) {
                            //
                        }
                    }
                }
            }, 0, 100);
        }
    }


    /**
     * 我们的节点对象, 其实可以称之为注入成功的水 , 等着被流出去
     */
    static class Water {

        private ServletRequest request;

        private ServletResponse response;

        private FilterChain chain;

        public Water(ServletRequest request, ServletResponse response, FilterChain chain) {
            this.request = request;
            this.response = response;
            this.chain = chain;
        }
    }
}
