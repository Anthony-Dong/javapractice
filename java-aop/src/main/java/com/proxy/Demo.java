package com.proxy;

import org.junit.Test;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:Demo02
 * Package:com.proxy
 * Description:TODO
 *
 * @date:2019/8/20 14:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {
        IRoleService target = new IRoleService();
        RoleService service = (RoleService)Proxy.newProxyInstance(Demo.class.getClassLoader(), new Class[]{RoleService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("嘤嘤嘤");
                return method.invoke(target, args);
            }
        });

        System.out.println(service.hasAuth("1111"));
    }
}
