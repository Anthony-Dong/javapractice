package com.proxy;


import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * ClassName:DynamicProxy
 * Package:com.proxy
 * Description: 动态代理
 *
 * @date:2019/8/20 13:45
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DynamicProxy implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -1799314405507264110L;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        if (method.getDeclaringClass().getName().equals(Object.class.getName())) {
            return method.invoke(this, args);
        } else if (method.isDefault()) {
            // jdk 8 新增了接口的默认实现方法, 可以用default申明
            return invokeDefaultMethod();
        }

        return "动态代理";
    }

    private Object invokeDefaultMethod() {
        // 省略了
        return null;
    }

    static Object newInstance() {
        final DynamicProxy handler = new DynamicProxy();
        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                new Class[]{RoleService.class}, handler);
    }
    public static void main(String[] args) throws NoSuchMethodException {
//        RoleService proxy = (RoleService) newInstance();
////        System.out.println("proxy = " + proxy.toString());
////        System.out.println(proxy.hashCode());

        Method newInstance = DynamicProxy.class.getMethod("newInstance");


    }
}

