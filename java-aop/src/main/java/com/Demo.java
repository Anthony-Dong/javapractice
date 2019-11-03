package com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;

/**
 * TODO
 *
 * @date:2019/10/12 19:21
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {

        HelloWorld proxyInstance = (HelloWorld) Proxy.newProxyInstance(Demo.class.getClassLoader(), new Class[]{HelloWorld.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                HelloWorld oppo = new HelloWorld() {
                    @Override
                    public void syaHelloWorld() {
                        System.out.println("Hello OPPO");
                    }
                };

                method.invoke(oppo, args);
                return oppo;
            }
        });

        HashSet<Object> objects = new HashSet<>();
        proxyInstance.syaHelloWorld();

    }

}

interface HelloWorld{
    void syaHelloWorld();
}


class HelloWorldImp implements HelloWorld {


    @Override
    public void syaHelloWorld() {
        System.out.println("Hello World !");
    }
}
