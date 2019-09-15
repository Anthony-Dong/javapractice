package com.javase.class_package;


import lombok.Data;

/**
 * 测试的实体类
 *
 * @date:2019/9/15 13:08
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
@TypeAnnotation("class")
public class Clazz extends DeFather{

    @FieldAnnotation("field")
    private String name;

    public Clazz(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Clazz() {
    }


    @MethodAnnotation("method")
    public void test(@ParamAnnotation("param") String param) {
        System.out.println("hello" + param);
    }
}
