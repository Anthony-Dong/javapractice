package com.javase.day08.stringUtils;

import java.io.File;

/**
 * ClassName:Animal
 * Package:com.javase.day08.stringUtils
 * Description:
 *
 * @date:2019/7/22 15:21
 * @author: 574986060@qq.com
 */

public abstract class Animal {
    abstract void move();
    public static void main(String[] args) {
        Animal bird = new Bird();
        bird.move();
        Animal fish = new Fish();
        System.out.println(bird instanceof Animal ? true : false);
        System.out.println(fish instanceof Animal ? true : false);
    }
}
class Bird extends Animal{
    @Override
    void move() {
        int i = 1 / 0;
        System.out.println("I am a Bird");
    }
}
class Fish extends Animal{
    @Override
    void move() {
        System.out.println("I am a Fish");
    }
}

