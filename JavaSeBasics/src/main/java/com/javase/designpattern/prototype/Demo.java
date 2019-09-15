package com.javase.designpattern.prototype;

/**
 * ClassName:Demo
 * Package:com.javase.designpattern.prototype
 * Description:TODO
 *
 * @date:2019/9/6 19:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("xiaoming", 100);


        Person clone = person.clone();

        System.out.println(clone);

        System.out.println(clone==person);
    }
}
