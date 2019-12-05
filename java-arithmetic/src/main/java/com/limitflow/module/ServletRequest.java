package com.limitflow.module;

/**
 * 模拟对象
 *
 * @date:2019/12/4 12:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class ServletRequest {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ServletRequest{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public ServletRequest(String msg) {
        this.msg = msg;
    }
}
