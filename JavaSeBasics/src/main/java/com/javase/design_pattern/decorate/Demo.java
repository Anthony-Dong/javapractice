package com.javase.design_pattern.decorate;

/**
 *  装饰着 模式设计的巧妙之处 就是 自己装饰自己 ,就是个 加工处理
 *
 * @date:2019/9/7 18:05
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {


    public static void main(String[] args) {

        String msg = "hello";

        String msg2 = new String("hello").intern();


        System.out.println(msg==msg2);

        Coffee myCoffee = new MyCoffee();

        float cost = myCoffee.cost();
        System.out.println(cost);

        System.out.println(myCoffee.getDesc());


        Decorate myDecorate = new MyDecorate(myCoffee);

        System.out.println(myDecorate.getDesc());
        System.out.println(myDecorate.cost());


        Decorate myDecorate1 = new MyDecorate(myDecorate);

        System.out.println(myDecorate1.getDesc());
        System.out.println(myDecorate1.cost());

    }


}
