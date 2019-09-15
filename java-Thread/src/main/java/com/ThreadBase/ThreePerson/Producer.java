package com.ThreadBase.ThreePerson;

/**
 * ClassName:Producer
 * Package:com.ThreadBase.ThreePerson
 * Description:
 *
 * @date:2019/8/2 0:01
 * @author: 574986060@qq.com
 */

public class Producer implements Runnable{

    private Product product;
    private static   int index = 0;
    public Producer(Product product) {
        this.product = product;
    }

    //            1代表有产品,3代表无产品
    @Override
    public  void  run() {

        while (true) {
            synchronized (product) {
  //            1代表无产品（消费者手中）,2代表有产品，可以传递(在生产者手中),3代表已传递，可以消费（传递着手中）
                while (product.getStatus() != 1) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (index % 2 == 0) {
                    product.setBrand("康师傅");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("红烧牛肉面");
                    product.setId(index);
                } else {
                    product.setBrand("娃哈哈");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setName("冰红茶");
                    product.setId(index);
                }

                product.setStatus(2);
                System.out.println("生产者:"+Thread.currentThread().getName()+" "+product.getBrand() + product.getName()+product.getId());
                product.notifyAll();
                index++;
            }
        }
    }
}
