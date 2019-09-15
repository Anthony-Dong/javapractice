package com.javase.day01.clone;

/**
 * ClassName:Person
 * Package:com.javase.day01
 * Description:
 *
 * @date:2019/6/28 9:33
 * @author: 574986060@qq.com
 */

public class PersonDeep implements Cloneable {
    private int age;
    private Person person;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        PersonDeep personDeep = (PersonDeep) super.clone();
        personDeep.person = (Person) person.clone();
        return personDeep;
    }
}
