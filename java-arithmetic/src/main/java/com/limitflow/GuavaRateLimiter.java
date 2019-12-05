package com.limitflow;

import com.google.common.util.concurrent.RateLimiter;
import com.limitflow.module.FilterChain;
import com.limitflow.module.ServletRequest;
import com.limitflow.module.ServletResponse;

import java.util.concurrent.TimeUnit;

/**
 * 令牌桶算法 , 基于 Google的 Guava 实现的 , 真的牛逼 , 不得不说
 * @date:2019/12/4 21:25
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class GuavaRateLimiter extends AbstractLimiter {

    /**
     * 令牌桶
     */
    private final RateLimiter limiter;

    /**
     * 每次需要的令牌个数
     */
    private static final int ACQUIRE_NUM = 1;
    /**
     * 最长等待时间
     */
    private static final int WAIT_TIME_PER_MILLISECONDS = 5;

    /**
     * 构造器 , 输入每秒最大流量
     *
     * @param MAX_FlOW 最大流量
     */
    public GuavaRateLimiter(final int MAX_FlOW) {
        super(MAX_FlOW);
        limiter = RateLimiter.create(MAX_FlOW);
    }


    @Override
    public void limit(ServletRequest request, ServletResponse response, FilterChain chain) {
        /**
         * 意思就是 我尝试去获取1个令牌 ,最大等待时间是 5 ms , 其实太长了, 真是开发也就1ms不到
         */
        boolean flag = limiter.tryAcquire(ACQUIRE_NUM, WAIT_TIME_PER_MILLISECONDS, TimeUnit.MILLISECONDS);
        if (flag) {
            chain.doFilter(request, response);
        }
    }
}
