package com.synchronized_test.block;


/**
 * 测试取钱
 *
 * @date:2019/9/22 15:59
 * @author: <a href='mailto:fanhaodong516@qq.com'>Anthony</a>
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;
 
    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    public void run(){
        synchronized (account){
            if(account.getBalance()>=drawAmount){
                System.out.println(getName() + "取钱成功，吐出钞票： " + drawAmount);
                try{
                    Thread.sleep(1);
                }catch(InterruptedException ex){
                    ex.getStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            }else{
                System.out.println(getName()+"取钱失败，余额不足");
            }
        }
    }
}