package com.proxy02;

import com.proxy.IRoleService;
import com.proxy.RoleService;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName:DaynamicProxy
 * Package:com.proxy02
 * Description:TODO
 *
 * @date:2019/8/20 15:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DaynamicProxy implements InvocationHandler {
//      真是的 代理对象 realProxy 对象 就是接口的实现类
    private final Object target;

    public DaynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        try {
            System.out.println("args = " + args.length);
            System.out.println(proxy.toString());
            return method.invoke(target, args);
        } finally {
            System.out.println("结束");
        }
    }

    /**
     * Proxy.newProxyInstance(1,2,3)
     * 1. 是类加载器
     * 2. 是接口的类字节码
     * 3.是 invocationHandler
     * @param target
     * @return
     */
    public static Object getProxy(Object target) {
        DaynamicProxy handler = new DaynamicProxy(target);

        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
               target.getClass().getInterfaces(), handler);
    }


    public static void main(String[] args) {

//        RoleService proxy = (RoleService)getProxy(new IRoleService());
//
//        proxy.hasAuth("11");


        System.out.println(System.getProperty("user.dir"));
    }
}
