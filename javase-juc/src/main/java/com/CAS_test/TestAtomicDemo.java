package com.CAS_test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo{
    public static void main(String[] args){

        AtomicDemo ad = new AtomicDemo();

        for(int i=0; i < 10; i++){
            new Thread(ad).start();
        }


        SolveAtomicDemo sad = new SolveAtomicDemo();
        for(int i=0; i < 10; i++){
            new Thread(sad).start();
        }

    }
}

class AtomicDemo implements Runnable{
    // 由于我们就只创建了一个 实例对象, 加不加static是效果 一样的
    private  int serialNumber = 0;

    public void run(){

        try{
            Thread.sleep(20);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
    }

    private int getSerialNumber(){
        return serialNumber++;
    }
}
class  SolveAtomicDemo implements Runnable{

    //  创建一个原子变量
    private AtomicInteger serialNumber = new AtomicInteger();


    //
    @Override
    public void run() {
        try{
            Thread.sleep(20);
        }catch(InterruptedException e){

        }

        System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());

    }

    private int getSerialNumber(){
        // 自增 ==  i++
        return serialNumber.getAndIncrement();
    }
}

