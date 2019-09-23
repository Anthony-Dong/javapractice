package com.synchronized_test;

public class Test{
    public static void main(String[] args){
        Demo demo = new Demo();

        Demo demo2 = new Demo();

        new Thread(() -> demo.getOne()).start();

        new Thread(() -> {
            // demo2.getTwo();
            System.out.println("---two ");
            demo.getTwo();
        }).start();
    }
}

class Demo{
    public  static synchronized void getOne(){
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//
//        }

        System.out.println("one");
    }

    public  static synchronized void getTwo(){
        System.out.println("two");
    }

}