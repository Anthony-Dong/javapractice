package com.ThreadBase.ThreePerson;

/**
 * ClassName:Consumer
 * Package:com.ThreadBase.ThreePerson
 * Description:
 *
 * @date:2019/8/2 0:01
 * @author: 574986060@qq.com
 */

public class Consumer implements Runnable {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    @Override
    public  void run() {
        while (true) {
            synchronized (product) {
//          1代表无产品,2代表有产品，可以传递,3代表已传递，可以消费
                while (product.getStatus() != 3) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    String brand = product.getBrand();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String name = product.getName();
                    product.setStatus(1);
                    System.out.println("消费者:"+Thread.currentThread().getName()+" " + brand + name+product.getId());
                    product.notifyAll();

            }
        }
    }
}
