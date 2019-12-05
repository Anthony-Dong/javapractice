package com.limitflow;

import com.limitflow.module.FilterChain;
import com.limitflow.module.ServletRequest;
import com.limitflow.module.ServletResponse;

/**
 * @date:2019/12/4 16:47
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public abstract class AbstractLimiter {

    /**
     * 最大流量
     */
    protected final int MAX_FlOW;

    /**
     * 构造器 , 输入每秒最大流量
     * @param MAX_FlOW 最大流量
     */
    public AbstractLimiter(int MAX_FlOW) {
        this.MAX_FlOW = MAX_FlOW;
    }


    /**
     * 具体实现的方法
     * @param request 请求
     * @param response 响应
     * @param chain 执行
     */
    public abstract void limit(ServletRequest request, ServletResponse response, FilterChain chain);

}
