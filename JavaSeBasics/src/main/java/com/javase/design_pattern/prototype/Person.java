package com.javase.design_pattern.prototype;

/**
 * ClassName:Person
 * Package:com.javase.design_pattern.prototype
 * Description:TODO
 *
 * @date:2019/9/6 19:30
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Person implements Cloneable{

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
