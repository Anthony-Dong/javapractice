package com.limitflow.module;

public interface Filter {

    default public void init() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain);

    default public void destroy() {
    }
}
