package com.javase.day09.thrad.DoThread;

public class InteruptTest extends Thread {
	static int i = 0;
 
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			// i happy run , please break me
			System.out.println("I'm runing " + i++);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();//①：发出中断请求，设置中断状态
				System.out.println("判断中断状态"+Thread.currentThread().isInterrupted());//②:判断中断状态（不清除中断状态）
				System.out.println("判断中断状态"+Thread.interrupted());//③:判断中断状态（清除中断状态）
			}
			System.out.println("current SocketIO haven't been broken");
		}
 
	}
 
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new InteruptTest();
		t1.start();
		Thread.sleep(100);
		t1.interrupt();
	}
}
