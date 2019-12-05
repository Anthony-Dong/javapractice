package com.limitflow.module;

import java.io.IOException;

/**
 * TODO
 *
 * @date:2019/12/4 12:29
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public interface FilterChain {

    void doFilter(ServletRequest request, ServletResponse response);
}
