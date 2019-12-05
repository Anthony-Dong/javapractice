package com.limitflow;

import com.limitflow.module.Filter;
import com.limitflow.module.FilterChain;
import com.limitflow.module.ServletRequest;
import com.limitflow.module.ServletResponse;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @date:2019/12/4 12:49
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    @Test
    public void test() {

        // 过滤器
        Filter filter = new Filter() {
            AbstractLimiter limit = null;

            @Override
            public void init() {
                // 入口
                limit = new TokenBucketLimiter(100);
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
                limit.limit(request, response, chain);
            }
        };

        // 过滤器初始化
        filter.init();

        // 计时器
        long start = System.currentTimeMillis();

        // 计数器
        AtomicInteger integer = new AtomicInteger(0);

        ExecutorService pool = Executors.newFixedThreadPool(10);
        IntStream.range(0, 4000).forEach(e -> {
            try {
                // 模拟请求延迟
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            // 多线程执行
            pool.execute(() -> {
                filter.doFilter(new ServletRequest("" + e), new ServletResponse(), new FilterChain() {
                    @Override
                    public void doFilter(ServletRequest request, ServletResponse response) {
                        // 回调接口
                        integer.incrementAndGet();
                        System.out.println("请求 : " + request.getMsg() + " 通过, 执行线程 " + Thread.currentThread().getName() + " , 当前时间 : " + System.currentTimeMillis());
                    }
                });
            });

        });

        System.out.println("总耗时" + (System.currentTimeMillis() - start));
        System.out.println("一共通过 : " + integer.get());
    }
}
