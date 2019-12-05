package com.limitflow;

import com.limitflow.module.FilterChain;
import com.limitflow.module.ServletRequest;
import com.limitflow.module.ServletResponse;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 计数器算法
 *
 * @date:2019/12/4 12:26
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class CounterLimiter extends AbstractLimiter {

    private static final Integer initFlow = 0;

    private final AtomicInteger flow;


    public CounterLimiter(int MAX_FlOW) {
        super(MAX_FlOW);

        flow = new AtomicInteger(initFlow);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                flow.set(initFlow);
            }
        }, 0, 1000);

    }

    public void limit(ServletRequest request, ServletResponse response, FilterChain chain) {
        if (flow.get() < MAX_FlOW) {
            chain.doFilter(request, response);
            flow.incrementAndGet();
        }
    }
}
