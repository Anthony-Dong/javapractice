package com.demo.test;


import com.demo.config.ComponentScan;
import com.demo.config.InternalResourceViewResolver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * TODO
 *
 * @date:2019/9/15 14:38
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestClass {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/config/springMVC.xml");



        InternalResourceViewResolver bean = (InternalResourceViewResolver) context.getBean("internalResourceViewResolver");

        String prefix = bean.getPrefix();

        String suffix = bean.getSuffix();

        System.out.println(prefix);

        System.out.println(suffix);





        ComponentScan componentScan = context.getBean("componentScan", ComponentScan.class);
        String basePackage = componentScan.getBasePackage();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(basePackage);


        String[] beanNamesForAnnotation = applicationContext.getBeanNamesForAnnotation(Controller.class);

        for (String s : beanNamesForAnnotation) {

            Object bean1 = applicationContext.getBean(s);
            Class<?> aClass = bean1.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {

                Parameter[] parameters = declaredMethod.getParameters();

                if (declaredMethod.getName().equals("get3")) {
                    try {
                        Object invoke = declaredMethod.invoke(bean1, null);
                        System.out.println("invoke = " + invoke);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }

                if (null != parameters) {
                    for (Parameter parameter : parameters) {
                        String name = parameter.getName();
                        System.out.println(name);

                        Class<?> type = parameter.getType();
                        System.out.println(type.getName());

                        String typeName = HttpServletRequest.class.getTypeName();

                        System.out.println("typeName = " + typeName);

                        System.out.println(type.getName().equals(typeName));



                    }

                }
            }



        }
    }


}
