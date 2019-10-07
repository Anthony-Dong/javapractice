package com.proxy;




import java.lang.reflect.InvocationHandler;
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

public class DynamicProxy implements InvocationHandler {
    private final Object subject;


    public DynamicProxy(Object subject) {

        this.subject = subject;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        int time=0;
        while (time <= RetryConstant.MAX_TIMES) {
            try {
                System.out.println("timer_task:"+time);

                if (new Random().nextInt(2) == 1 ? true : false) {
                    int i = 1 / 0;
                }
                // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
                return method.invoke(subject, args);
            } catch (Exception e) {
                time++;
                if (time > RetryConstant.MAX_TIMES) {
                    throw new RuntimeException("失败");
                }
            }finally {
                System.out.println("--------------执行一次操作完毕");
            }
        }
        return null;
    }

    /**
     * 获取动态代理
     *
     * @param realSubject 代理对象
     */
    public static Object getProxy(Object realSubject) {
        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);
        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);

    }


    public static void main(String[] args) {

//        DynamicProxy dynamicProxy = new DynamicProxy(new IRoleService());

        RoleService proxy = (RoleService)getProxy(new IRoleService());
        System.out.println("proxy.hasAuth(\"1\") = " + proxy.hasAuth("1"));
        int i = 10;
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println("new Random().nextInt(2) = " + new Random().nextInt(2));
        }
    }
}

