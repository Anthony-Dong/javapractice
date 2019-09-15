package com.proxy;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.lang.reflect.Proxy;


/**
 * ClassName:UserProxy
 * Package:com.tyut.proxy
 * Description:
 *
 * @date:2019/6/22 15:54
 * @author: 574986060@qq.com
 */

public class UserProxy {

    private final RoleService userService=new IRoleService();


    public IRoleService getUserService() {
       return (IRoleService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), (proxy, method, args) -> {
                   IRoleService invoke = null;
                   try {
                        invoke = (IRoleService)method.invoke(userService, args);
                       return invoke;
                   } catch (Throwable e) {

                       throw new RuntimeException(e);
                   }finally {

                   }
       });

    }
}