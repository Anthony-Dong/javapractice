package com.example.spi;

import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @date:2019/11/7 11:58
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class RunDemo {

    public static void main(String[] args) {
        ServiceLoader<EchoService> services = ServiceLoader.load(EchoService.class);



        Iterator<EchoService> iterator = services.iterator();


        iterator.forEachRemaining(echoService -> {
            System.out.println("echoService.echo(\"hello\") = " + echoService.echo("hello"));
        });



    }


}
