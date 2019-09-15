package com.ThreadBase.ThreePerson;

/**
 * ClassName:Dispatcher
 * Package:com.ThreadBase.ThreePerson
 * Description:
 *
 * @date:2019/8/2 0:02
 * @author: 574986060@qq.com
 */

public class Dispatcher implements Runnable{
    private Product product;

    public Dispatcher(Product product) {
        this.product = product;
    }

//    1代表有产品,2代表发货,3代表无产品
    @Override
    public  void run() {
        while (true) {
            synchronized (product) {
//          1代表无产品,2代表有产品，可以传递,3代表已传递，可以消费
                while (product.getStatus() != 2) {
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

                product.setStatus(3);
                System.out.println("发送者:"+Thread.currentThread().getName()+" " + brand + name+product.getId());
                product.notifyAll();
            }
        }
    }
}
