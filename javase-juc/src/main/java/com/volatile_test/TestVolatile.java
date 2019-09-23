package com.volatile_test;

public class TestVolatile{

    public static void main(String[] args){
        ThreadDemo td = new ThreadDemo();
        // 子线程
        Thread thread = new Thread(td);

        thread.start();



        // 主线程  对于 子线程的改变并不知情, 主要是 由于主线程先执行 ,他不知道 子线程的改变 如果我们让子线程 join一下就发生改变 了
        while(true){
            if(td.isFlag()){
                System.out.println(td.isFlag());
                break;
            }
        }
    }
}

class ThreadDemo implements Runnable{
    //  加与不加的区别  (不加 由于子线程改变了 flag ,主线程不知道他改变 ,所以会无限循环下去 上面的while代码  )
    private   boolean flag = false;

    public void run(){
        try{
            // 该线程 sleep(200), 导致了程序无法执行成功
            Thread.sleep(200);
        }catch(Exception e){
            e.printStackTrace();
        }

        flag = true;

        System.out.println("flag: "+flag);
    }

    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }
}