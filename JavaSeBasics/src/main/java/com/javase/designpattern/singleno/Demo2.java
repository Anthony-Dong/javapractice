package com.javase.designpattern.singleno;

/**
 * TODO
 *
 * @date:2019/9/21 0:07
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */

public class Demo2 {
    private final static String msg = "";


    public static void main(String[] args) {

        System.out.println(Singleton2.getInstance(1111111111).hashCode());

        System.out.println(Singleton2.getInstance(2222).hashCode());
        System.out.println(Singleton2.getInstance(3333).hashCode());
    }

}

class Singleton2 {


    Integer masg;

    public Singleton2(Integer masg) {
        this.masg = masg;
    }


    private static final Singleton2 SINGLETON_2;


    static {
        SINGLETON_2 = new Singleton2();
    }

    public Singleton2(){

    }



    public Integer getMasg() {
        return masg;
    }



    public void setMasg(Integer masg) {
        this.masg = masg;
    }



    public static synchronized Singleton2 getInstance(Integer msg){
        synchronized (msg) {
            SINGLETON_2.setMasg(msg);
        }
        return SINGLETON_2;
    }
}
