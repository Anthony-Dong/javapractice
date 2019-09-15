package com.javase.day02.enumtest;

import com.javase.day01.clone.Person;

import java.util.Enumeration;
import java.util.List;

/**
 * ClassName:EnumerationTest
 * Package:com.javase.day02
 * Description:
 *
 * @date:2019/6/29 11:30
 * @author: 574986060@qq.com
 */

/**
 * 自定义枚举类  需要实现 enumeration  接口  需要实现接口方法
 */

public class EnumerationTest implements Enumeration<String> {

    private List<String> list;
    private int length;
    private int start;

    public EnumerationTest(List<String> list, int length, int start) {
        this.list = list;
        this.length = length;
        this.start = start;
    }

    @Override

    public boolean hasMoreElements() {
        return start<length;
    }

    @Override
    public String nextElement() {

        return list.get(this.start++);
    }


}
