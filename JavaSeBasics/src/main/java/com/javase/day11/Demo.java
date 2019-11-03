package com.javase.day11;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 * ClassName:demos
 * Package:com.javase.day11
 * Description:
 *
 * @date:2019/8/2 18:58
 * @author: 574986060@qq.com
 */

public class Demo {


    @Test
    public void sayHello() throws Exception {
        ServiceLoader<IFather> serviceLoader = ServiceLoader.load(IFather.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(IFather::sayHello);

//        Properties properties = new Properties();

//        InputStream resourceAsStream = demos.class.getResourceAsStream("db.properties");
//        properties.load(resourceAsStream);

//        Object url = properties.get("url");
//        System.out.println(url);

        Demo demo = new Demo();
        Class<? extends Demo> aClass = demo.getClass();
    }
}
