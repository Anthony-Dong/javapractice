package com.example.spi;

/**
 * TODO
 *
 * @date:2019/11/7 11:55
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class FinalEchoService implements EchoService {

    public FinalEchoService() {
        System.out.println("FinalEchoService 无参构造器");
    }

    private int x;

    public FinalEchoService(int x) {
        this.x = x;
    }

    @Override
    public String echo(String msg) {
        return "FinalEchoService : "+msg;
    }
}
