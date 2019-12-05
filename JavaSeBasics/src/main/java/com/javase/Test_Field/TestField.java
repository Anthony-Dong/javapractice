package com.javase.Test_Field;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * TODO
 *
 * @date:2019/11/20 17:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class TestField {


    public static void main(String[] args) throws Exception {

        Person person = new Person();

        person.setName("原来");
        person.setAge(1);

        // age 获取
        Field age = person.getClass().getDeclaredField("age");
        System.out.println("age.get(person) = " + age.get(person));


        // name 字段
        Field name = Class.forName("com.javase.Test_Field.Person").newInstance().getClass().getDeclaredField("name");
        Value v = name.getAnnotation(Value.class);
        System.out.println("v.value() = " + v.value());
        name.setAccessible(true);
        name.set(person, "aaaaaaaaaa");
        System.out.println("name.get(person) = " + name.get(person));
    }

}

class Person {

    @Value("${sb}")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}