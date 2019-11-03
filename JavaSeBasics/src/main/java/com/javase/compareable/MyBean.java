package com.javase.compareable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @date:2019/10/23 17:09
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class MyBean implements Comparable<MyBean>{

    int x;

    public MyBean(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "x=" + x +
                '}';
    }

    // o 指代的是前面那个对象 ======
    @Override
    public int compareTo(MyBean o) {
        System.out.println("=================");
        System.out.println(o.x);

        System.out.println(this.x);
        return this.x > o.x ? -1 : this.x == x ? 0 : 1;
    }


    public static void main(String[] args) {
        MyBean myBean = new MyBean(1);

        MyBean myBean1 = new MyBean(2);

        MyBean myBean2 = new MyBean(3);


        List<MyBean> list1 = Arrays.asList(myBean, myBean1, myBean2);

        list1.stream().sorted().forEach(e->{
            System.out.println(e);
        });
    }
}
