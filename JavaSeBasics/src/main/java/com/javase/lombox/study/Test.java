package com.javase.lombox.study;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * ClassName:Test
 * Package:com.javase.lombox.study
 * Description:TODO
 *
 * @date:2019/9/3 23:32
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Test {

    public static void main(String[] args) {

        PetShop petShop = new PetShop();

        petShop.add(new Dog("aaa", "11"));
        petShop.add(new Cat("cat", "11"));
        petShop.add(new Dog("dog", "11"));

        petShop.search("a").forEach(System.out::println);

    }

}

class  PetShop {

    private List<Animal> animals = new ArrayList<>();



    void  add(Animal animal){
        animals.add(animal);
    }


    List<Animal> search(String aim){

        return this.animals.stream().filter(a -> a.getName().contains(aim)).
                collect((Collectors.toList()));
    }

}

class  Animal{
    private String name;
    private String id;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public Animal(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class  Cat extends Animal{


    public Cat(String name, String id) {
        super(name, id);
    }
}


class  Dog extends Animal{

    public Dog(String name, String id) {
        super(name, id);
    }
}