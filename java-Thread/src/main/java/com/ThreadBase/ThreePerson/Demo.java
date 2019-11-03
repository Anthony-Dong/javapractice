package com.ThreadBase.ThreePerson;

/**
 * ClassName:demos
 * Package:com.ThreadBase.ThreePerson
 * Description:
 *
 * @date:2019/8/2 0:15
 * @author: 574986060@qq.com
 */

public class Demo {
    public static void main(String[] args) {
        Product product = new Product();
        product.setStatus(1);

        Runnable producer = new Producer(product);
        Runnable consumer = new Consumer(product);
        Runnable dispatcher = new Dispatcher(product);

        new Thread(producer,"员工1").start();
        new Thread(dispatcher,"发货1").start();
        new Thread(consumer,"吃货1").start();

//
        new Thread(producer,"员工2").start();
        new Thread(dispatcher,"发货2").start();
        new Thread(consumer,"吃货2").start();

        new Thread(producer,"员工2").start();
        new Thread(dispatcher,"发货2").start();
        new Thread(consumer,"吃货2").start();

        new Thread(producer,"员工3").start();
//        new Thread(dispatcher,"发货3").start();
        new Thread(consumer,"吃货3").start();
    }
}
