package com.javase.java8_new_feature.lambdaTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName:Person
 * Package:com.javase.java8_new_feature.lambdaTest
 * Description:
 *
 * @date:2019/7/11 22:09
 * @author: 574986060@qq.com
 */
@Data

@AllArgsConstructor
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person() {
    }


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
