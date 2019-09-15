package com.javase.designpattern.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**

 * @date:2019/9/6 22:27
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class DeepClone {
    public static void main(String[] args) throws Exception {
        Child child = new Child();
        child.setName("111111");

        // 这种方式  只是浅拷贝
        Persons persons = new Persons("111111",child);
        Persons persons1 = (Persons) persons.clone();
        System.out.println(persons1.getChild().getName());

        child.setName("22222222");

        System.out.println(persons1.getChild().getName());


        System.out.println(persons.getChild() == persons1.getChild());

        System.out.println(persons.getName()==persons1.getName());


        //2.深度拷贝
        //或者就是 clone 每个对象 这种方式太过于麻烦  如果每个对象 就要克隆每个对象
        System.out.println("-------深度拷贝-----------");


        Persons persons2 = persons.deepClone();


        System.out.println(persons2.getChild().getName());

        // 我们尝试修改
        child.setName("333333333333");

        System.out.println(persons2.getChild().getName());



        System.out.println(persons2.getChild() == persons.getChild());
        System.out.println(persons2.getName()==persons.getName());


        System.out.println("--------------------------------");


    }

}




class Persons implements Cloneable, Serializable {
    private static final long serialVersionUID = 6326831644167366808L;
    private String name;

    private Child child;

    public Persons(String name, Child child) {
        this.name = name;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public Child getChild() {
        return child;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public Persons deepClone() throws Exception {

        //1.序列化
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
        objectOutputStream.writeObject(this);

        //2. 反序列化
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteOutputStream.getBytes());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Object o = objectInputStream.readObject();

        return (Persons) o;
    }

}

class Child implements Cloneable,Serializable{
    private static final long serialVersionUID = 8731537808020251703L;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}