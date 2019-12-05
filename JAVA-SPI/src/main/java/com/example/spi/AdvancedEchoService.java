package com.example.spi;

/**
 * TODO
 *
 * @date:2019/11/7 12:06
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class AdvancedEchoService implements EchoService{

    @Override
    public String echo(String msg) {
        return "AdvancedEchoService :" + msg;
    }
}
