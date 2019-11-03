package com.javase.design_pattern.singleno;

/**
 * ClassName:demos
 * Package:com.javase.design_pattern
 * Description:TODO
 *
 * @date:2019/9/6 18:01
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();

        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance.equals(instance1));
        System.out.println(instance==instance1);


        EnumSingnleton singnleton = EnumSingnleton.INSTANCE;
        EnumSingnleton singnleton2 = EnumSingnleton.INSTANCE;




        System.out.println(singnleton == singnleton2);

        singnleton.say();


    }



}
