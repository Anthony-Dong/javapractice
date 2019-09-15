package com.demo.core;

import com.demo.annotation.RequestMapping;
import com.demo.config.ComponentScan;
import com.demo.config.RequestMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.config.InternalResourceViewResolver ;
import org.springframework.stereotype.Controller;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TODO
 *
 * @date:2019/9/15 13:57
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */


public class dispatcherServlet extends HttpServlet {

    // 我们需要两个map ,一个是 classname - map
    private static ConcurrentHashMap<String, Object> METHOD_MAPPING = new ConcurrentHashMap<>();


    // 放入一个 uri 和 一个 method对象
    private static ConcurrentHashMap<String, Mappings> URI_MAPPING = new ConcurrentHashMap<>();


    // 前缀
    private static String PREFIX;

    // 后缀
    private static String SUFFIX;


    //  处理器
    public void handler(HttpServletRequest req, HttpServletResponse resp){
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 获取请求方法
        String reqMethod = req.getMethod();

        // 获取请求路径
        String requestURI = req.getRequestURI();


        String uriPath = getURIPath(requestURI, reqMethod);

        // 找到实例方法
        Mappings mappings = URI_MAPPING.get(uriPath);
        Object bean = METHOD_MAPPING.get(mappings.getMethodPath());
        Method method = mappings.getMethod();


        // 参数
        Parameter[] parameters = method.getParameters();


        // 用list愿意是保证有序性
        ArrayList<Object> list = new ArrayList<>();

        if (null != parameters && parameters.length > 0) {
            for (Parameter parameter : parameters) {
                String parameterName = parameter.getName();
                // 如果是一个请求参数 怎么办  ,这么办
                String name = req.getParameter(parameterName);
                if (null != name ) {
                    list.add(name);
                }
                String type = parameter.getType().getName();

                if (type.equals(HttpServletRequest.class.getTypeName())) {
                    list.add(req);
                }
                if (type.equals(HttpServletResponse.class.getTypeName())) {
                    list.add(resp);
                }
            }
        }

        try {

            Object invoke = null;

            if (list.size() == 0) {

                invoke = method.invoke(bean, new Object[]{});
            } else {
                Object[] objects = list.toArray();

                invoke = method.invoke(bean, objects);
            }
            if (null != invoke) {
                String path = (String) invoke;

                // 请求转发的路径
                String paths = PREFIX + path + SUFFIX;
                req.getRequestDispatcher(paths).forward(req,resp);
            }

        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        } catch (InvocationTargetException e) {
//            e.printStackTrace();
        } catch (ServletException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        handler(req, resp);
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handler(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handler(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handler(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handler(req, resp);
    }




    @Override
    public void destroy() {

        System.out.println("destroy");
    }



    @Override
    public void init(ServletConfig config) throws ServletException {

        String contextConfigLocation = config.getInitParameter("contextConfigLocation");

        if (null != contextConfigLocation) {

            ApplicationContext context = new ClassPathXmlApplicationContext(contextConfigLocation);

            InternalResourceViewResolver bean = (InternalResourceViewResolver) context.getBean("internalResourceViewResolver");
            PREFIX = bean.getPrefix();
            SUFFIX = bean.getSuffix();

            ComponentScan componentScan = context.getBean("componentScan", ComponentScan.class);
            handlerMapping(componentScan);
        }

    }



    private void handlerMapping(ComponentScan componentScan ){
        // 获取自动扫描
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(componentScan.getBasePackage());

        // beanName 是唯一的这个由 spring管理,我这里不处理
        String[] controllerBeanNames = applicationContext.getBeanNamesForAnnotation(Controller.class);

        for (String controllerBeanName : controllerBeanNames) {

            // 获取controller对象
            Object controller = applicationContext.getBean(controllerBeanName);

            // 获取字节码文件
            Class<?> aClass = controller.getClass();

            // 获取方法
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method method : declaredMethods) {

              // key=方法名+beanName , value =Bean
              METHOD_MAPPING.put(getMethodPath(method, controllerBeanName), controller);

                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);

                // 获取 映射路径 uri
                String uri = requestMapping.value();


                Mappings mappings = new Mappings(getMethodPath(method, controllerBeanName),requestMapping.method(), method);

                // key=uri路径+ 方法名称 , value =Mappings对象(方法path ,get/post方法 , method对象)
                URI_MAPPING.put(getURIPath(uri,requestMapping.method().name()), mappings);

            }
        }


    }

    private String getMethodPath(Method method, String controllerBeanName) {


        return method.getName() + "_" + controllerBeanName;
    }

    private String getURIPath(String uri, String requestMethod) {

        return uri + "_" + requestMethod;
    }
}


class Mappings{
    String methodPath;

    RequestMethod requestMethod;

    Method method;

    public Mappings(String methodPath, RequestMethod requestMethod, Method method) {
        this.methodPath = methodPath;
        this.requestMethod = requestMethod;
        this.method = method;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public Method getMethod() {
        return method;
    }
}