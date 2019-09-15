package com.javase.day01.clone;

/**
 * ClassName:Person
 * Package:com.javase.day01
 * Description:
 *
 * @date:2019/6/28 9:33
 * @author: 574986060@qq.com
 */

public class Person implements Cloneable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
