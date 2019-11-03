package com.javase.cloneObj;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;

/**
 * TODO
 *
 * @date:2019/10/24 12:15
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestDemo {


    @Test
    public void test(){

        ArrayList<MyBean> myBeans = new ArrayList<>();

        MyBean myBean = new MyBean("name1");
        myBeans.add(myBean);


        MyBean myBean1 = new MyBean("name2");



        BeanUtils.copyProperties(myBean1, myBean,MyBean.class);


        System.out.println(myBean1);

    }






}


class MyBean{

    String name;

    public MyBean(String name) {
        this.name = name;
    }

    public MyBean() {
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}';
    }
}