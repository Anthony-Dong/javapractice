package com.javase.day08.stringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName:Person
 * Package:com.javase.day07.lambdaTest
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
